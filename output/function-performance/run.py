"""Compile the actual registry plus a standalone JMH call-overhead benchmark."""
from pathlib import Path
import hashlib
import json
import subprocess

out = Path(__file__).resolve().parent
root = out.parents[1]
maven = Path.home() / '.m2/repository'
jdk = Path('C:/Program Files/jdk-17.0.9/bin')
jars = [maven / name for name in (
    'org/openjdk/jmh/jmh-core/1.35/jmh-core-1.35.jar',
    'org/openjdk/jmh/jmh-generator-annprocess/1.35/jmh-generator-annprocess-1.35.jar',
    'net/sf/jopt-simple/jopt-simple/5.0.4/jopt-simple-5.0.4.jar',
    'org/apache/commons/commons-math3/3.6.1/commons-math3-3.6.1.jar',
)]
assert all(path.exists() for path in jars)
registry = root / ('rule-engine-expression-parser/com.act21.rule.engine.dsl.expression.parent/'
                   'com.act21.rule.engine.dsl.expression/src/com/act21/rule/engine/dsl/'
                   'expression/functions/FunctionRegistry.java')
classes = out / 'classes'
classes.mkdir(exist_ok=True)
cp = ';'.join(map(str, jars))
compile_command = [str(jdk / 'javac.exe'), '-cp', cp, '-processorpath', cp,
                   '-d', str(classes), str(registry), str(out / 'InvocationBenchmark.java')]
subprocess.run(compile_command, check=True)
command = [str(jdk / 'java.exe'), '-cp', str(classes) + ';' + cp,
           'org.openjdk.jmh.Main', 'local.benchmark.InvocationBenchmark',
           '-f', '2', '-wi', '3', '-i', '3', '-w', '500ms', '-r', '500ms',
           '-t', '1', '-jvmArgs', '-Xms256m -Xmx256m', '-prof', 'gc',
           '-rf', 'json', '-rff', str(out / 'results.json')]
(out / 'run-metadata.json').write_text(json.dumps({
    'compile_command': compile_command,
    'benchmark_command': command,
    'registry_sha256': hashlib.sha256(registry.read_bytes()).hexdigest(),
    'benchmark_sha256': hashlib.sha256((out / 'InvocationBenchmark.java').read_bytes()).hexdigest(),
    'scope': 'Tiny public instance Long add(Long,Long), rotating preallocated inputs, boxed result. '
             'No workbook parsing, grid conditions, batch traversal, conversions, varargs or concurrency. '
             'Short local JMH experiment; not production latency/throughput evidence.'
}, indent=2) + '\n', encoding='utf-8')
with (out / 'run.log').open('w', encoding='utf-8') as log:
    subprocess.run(command, stdout=log, stderr=subprocess.STDOUT, check=True)
results = json.loads((out / 'results.json').read_text(encoding='utf-8'))
for result in results:
    print(result['benchmark'].split('.')[-1], result['primaryMetric']['score'],
          result['primaryMetric']['scoreUnit'],
          next(metric['score'] for name, metric in result['secondaryMetrics'].items()
               if name.endswith('gc.alloc.rate.norm')), 'B/op')
