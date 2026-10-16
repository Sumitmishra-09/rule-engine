"""Regenerate Xtext 2.28 artifacts in staging; copy only generated outputs to a checkout."""
import argparse
from pathlib import Path
import shutil
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--workspace', type=Path, default=ROOT)
    parser.add_argument('--output', type=Path, default=ROOT / 'output/parser-generation')
    parser.add_argument('--offline', action='store_true')
    args = parser.parse_args()
    out = args.output.resolve()
    out.mkdir(parents=True, exist_ok=True)
    parent = args.workspace.resolve() / 'rule-engine-expression-parser/com.act21.rule.engine.dsl.expression.parent'
    stage = Path(tempfile.mkdtemp(prefix='sources-', dir=out))
    shutil.copytree(parent, stage / parent.name,
                    ignore=shutil.ignore_patterns('target', 'src-gen', 'xtend-gen', '.settings', 'generated'))
    staged_parent = stage / parent.name
    dsl_name = 'com.act21.rule.engine.dsl.expression'
    dependencies = ''.join('<dependency><groupId>' + group + '</groupId><artifactId>' + name
                           + '</artifactId><version>' + version + '</version></dependency>'
                           for group, name, version in [
                               ('org.eclipse.xtext', 'org.eclipse.xtext.xtext.generator', '2.28.0'),
                               ('org.eclipse.xtext', 'org.eclipse.xtext.xbase', '2.28.0'),
                               ('org.eclipse.emf', 'org.eclipse.emf.mwe2.launch', '2.13.0'),
                               ('org.eclipse.xtext', 'xtext-antlr-generator', '2.1.1')])
    (out / 'pom.xml').write_text('<project xmlns="http://maven.apache.org/POM/4.0.0"><modelVersion>4.0.0</modelVersion>'
                               '<groupId>local.verification</groupId><artifactId>parser-generation</artifactId>'
                               '<version>1</version><dependencyManagement><dependencies><dependency>'
                               '<groupId>org.eclipse.xtext</groupId><artifactId>xtext-dev-bom</artifactId>'
                               '<version>2.28.0</version><type>pom</type><scope>import</scope>'
                               '</dependency></dependencies></dependencyManagement><dependencies>'
                               + dependencies + '</dependencies></project>', encoding='utf-8')
    java = Path('C:/Program Files/jdk-17.0.9/bin/java.exe')
    maven = Path('C:/Program Files/apache-maven-3.9.6-bin/apache-maven-3.9.6')
    launcher = next((maven / 'boot').glob('plexus-classworlds-*.jar'))
    command = [str(java), f'-Dclassworlds.conf={maven / "bin/m2.conf"}', f'-Dmaven.home={maven}',
               f'-Dmaven.multiModuleProjectDirectory={out}', '-classpath', str(launcher),
               'org.codehaus.plexus.classworlds.launcher.Launcher', '-B', '-f', str(out / 'pom.xml')]
    if args.offline: command.append('-o')
    command += ['org.apache.maven.plugins:maven-dependency-plugin:3.6.1:build-classpath',
                '-Dmdep.outputFile=' + str(out / 'classpath.txt')]
    with (out / 'dependencies.log').open('w', encoding='utf-8') as log:
        subprocess.run(command, stdout=log, stderr=subprocess.STDOUT, check=True)
    cp = (out / 'classpath.txt').read_text(encoding='utf-8').strip() + ';' + str(staged_parent / dsl_name / 'src')
    command = [str(java), '-cp', cp, 'org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher',
               'com.act21.rule.engine.dsl.GenerateExpression', '-p', 'rootPath=' + staged_parent.as_posix()]
    with (out / 'generation.log').open('w', encoding='utf-8') as log:
        subprocess.run(command, cwd=staged_parent / dsl_name, stdout=log, stderr=subprocess.STDOUT, check=True)
    for module in staged_parent.iterdir():
        if not module.is_dir(): continue
        for relative in ['src-gen', 'model/generated']:
            generated = module / relative
            if generated.exists():
                shutil.copytree(generated, parent / module.name / relative, dirs_exist_ok=True)
    print('Generated artifacts copied to', parent)
    print('Logs:', out)


if __name__ == '__main__':
    main()
