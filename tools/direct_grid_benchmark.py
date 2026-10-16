"""Historical benchmark of generated rules against the pre-optimization generator.

Run registration_check.py first. Both paths use the current registry (including
cached parameter metadata); this isolates the change in generated invocation.
"""
from pathlib import Path
import argparse
import hashlib
import json
import subprocess
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parents[1]
parser = argparse.ArgumentParser(description=__doc__)
parser.add_argument('--workspace', type=Path, default=ROOT)
parser.add_argument('--build-output', type=Path, default=ROOT / 'output/function-registration')
parser.add_argument('--output', type=Path, default=ROOT / 'output/direct-grid-benchmark')
args = parser.parse_args()
registry_source = args.workspace.resolve() / (
    'rule-engine-expression-parser/com.act21.rule.engine.dsl.expression.parent/'
    'com.act21.rule.engine.dsl.expression/src/com/act21/rule/engine/dsl/expression/functions/FunctionRegistry.java')
if 'public Object invoke(' not in registry_source.read_text(encoding='utf-8'):
    raise SystemExit('This historical comparison requires the pre-cleanup FunctionRegistry.invoke API. '
                     'Use matching pre-cleanup checkouts/build output; saved measurements remain in '
                     'docs/evidence/main-direct-grid-performance.json.')
OUT = args.output.resolve()
OUT.mkdir(parents=True, exist_ok=True)
JDK = Path('C:/Program Files/jdk-17.0.9/bin')
M2 = Path.home() / '.m2/repository'
JARS = [M2 / path for path in (
    'org/openjdk/jmh/jmh-core/1.35/jmh-core-1.35.jar',
    'org/openjdk/jmh/jmh-generator-annprocess/1.35/jmh-generator-annprocess-1.35.jar',
    'net/sf/jopt-simple/jopt-simple/5.0.4/jopt-simple-5.0.4.jar',
    'org/apache/commons/commons-math3/3.6.1/commons-math3-3.6.1.jar',
)]
report = args.build_output.resolve() / ('target/surefire-reports/'
                                      'TEST-com.act21.impaktapps.rule.engine.test.DirectFunctionCallsTest.xml')
cp = ET.parse(report).find("./properties/property[@name='java.class.path']").attrib['value']
cp += ';' + ';'.join(map(str, JARS))
baseline = 'a6ba32ca1bbe2c2a1187d699512e9f3e61e0fc13'
generator = 'src/main/java/com/act21/impaktapps/rule/engine/compiler/Generator.java'
source = subprocess.check_output(['git', '-C', str(args.workspace.resolve() / 'rule-engine'), 'show', f'{baseline}:{generator}'], text=True)
source = source.replace('package com.act21.impaktapps.rule.engine.compiler;', 'package local.benchmark;')
source = source.replace('public class Generator {', 'public class LegacyGenerator {')
source = source.replace('public Generator() {', 'public LegacyGenerator() {')
(OUT / 'LegacyGenerator.java').write_text(source, encoding='utf-8')
classes = OUT / 'classes'
classes.mkdir(exist_ok=True)
compile_command = [str(JDK / 'javac.exe'), '-cp', cp, '-processorpath', cp, '-d', str(classes),
                   str(OUT / 'LegacyGenerator.java'), str(ROOT / 'tools/DirectGridBenchmark.java')]
subprocess.run(compile_command, check=True)
command = [str(JDK / 'java.exe'), '-cp', str(classes) + ';' + cp,
           'org.openjdk.jmh.Main', 'local.benchmark.DirectGridBenchmark',
           '-f', '2', '-wi', '3', '-i', '3', '-w', '1s', '-r', '1s', '-t', '1',
           '-jvmArgs', '-Xms256m -Xmx256m', '-jvmArgsAppend', f'-Dbenchmark.output={OUT}',
           '-prof', 'gc', '-rf', 'json', '-rff', str(OUT / 'results.json')]
metadata = {
    'baseline_generator_commit': baseline,
    'workspace': str(args.workspace.resolve()),
    'compile_command': compile_command, 'benchmark_command': command,
    'source_sha256': hashlib.sha256((ROOT / 'tools/DirectGridBenchmark.java').read_bytes()).hexdigest(),
    'scope': 'Warmed real generated single-batch MATCH_ALL grids, 1/100 PASS rows and one add output per row. '
             'Same current registry in both paths; parameter metadata caching also benefits the baseline. '
             'Compile/parse excluded; execution includes matching, assignments and statistics; '
             'a thread-owned fact/statistics object is reused and the executed-row list cleared each call. '
             'One thread, simple functions, no concurrent/batch/business-workbook performance claim.'
}
(OUT / 'metadata.json').write_text(json.dumps(metadata, indent=2) + '\n', encoding='utf-8')
with (OUT / 'run.log').open('w', encoding='utf-8') as log:
    subprocess.run(command, stdout=log, stderr=subprocess.STDOUT, check=True)
results = json.loads((OUT / 'results.json').read_text(encoding='utf-8'))
if len(results) != 4:
    raise SystemExit('Expected four results; inspect output/direct-grid-benchmark/run.log')
for item in results:
    print(item['benchmark'].split('.')[-1], item['params'], item['primaryMetric']['score'],
          item['primaryMetric']['scoreUnit'], next(value['score'] for name, value in item['secondaryMetrics'].items()
                                                  if name.endswith('gc.alloc.rate.norm')), 'B/op')
