#!/bin/bash

### grande gambiarra!
CP_PATH=".:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/stdlib/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/data-generation/bin:/home/leo/workspace/APEG/experiments/data-analyses/bin:/home/leo/workspace/APEG/experiments/data-analyses/lib/javacsv.jar:/usr/lib/eclipse/plugins/org.eclipse.ui_3.103.0.v20120705-114351.jar:/usr/lib/eclipse/plugins/org.eclipse.swt_3.100.1.v4234e.jar:/usr/lib/eclipse/plugins/org.eclipse.swt.gtk.linux.x86_64_3.100.1.v4234e.jar:/usr/lib/eclipse/plugins/org.eclipse.jface_3.8.101.v20120817-083647.jar:/usr/lib/eclipse/plugins/org.eclipse.core.commands_3.6.1.v20120814-150512.jar:/usr/lib/eclipse/plugins/org.eclipse.ui.workbench_3.103.1.v20120906-120042.jar:/usr/lib/eclipse/plugins/org.eclipse.e4.ui.workbench3_0.12.0.v20120521-2329.jar:/usr/lib/eclipse/plugins/org.eclipse.core.runtime_3.8.0.v20120521-2346.jar:/usr/lib/eclipse/plugins/org.eclipse.osgi_3.8.1.v20120830-144521.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.common_3.6.100.v20120522-1841.jar:/usr/lib/eclipse/plugins/org.eclipse.core.jobs_3.5.300.v20120622-204750.jar:/usr/lib/eclipse/plugins/org.eclipse.core.runtime.compatibility.registry_3.5.100.v20120521-2346/runtime_registry_compatibility.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.registry_3.5.200.v20120522-1841.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.preferences_3.5.0.v20120522-1841.jar:/usr/lib/eclipse/plugins/org.eclipse.core.contenttype_3.4.200.v20120523-2004.jar:/usr/lib/eclipse/plugins/org.eclipse.equinox.app_1.3.100.v20120522-1841.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/stdlib/bin:/usr/lib/eclipse/plugins/org.spoofax.jsglr_1.2.0.201308190125.jar:/usr/lib/eclipse/plugins/org.strategoxt.strj_1.2.0.201308190125:/usr/lib/eclipse/plugins/org.strategoxt.strj_1.2.0.201308190125/java/strategoxt.jar:/usr/lib/eclipse/plugins/org.strategoxt.imp.runtime_1.2.0.201308190125.jar:/usr/lib/eclipse/plugins/org.strategoxt.imp.nativebundle_1.2.0.201308190125:/usr/lib/eclipse/plugins/org.spoofax.terms_1.2.0.201308190125.jar:/usr/lib/eclipse/plugins/org.eclipse.jdt.core_3.8.2.v20120814-155456.jar:/usr/lib/eclipse/plugins/org.eclipse.jdt.compiler.apt_1.0.500.v20120522-1651.jar:/usr/lib/eclipse/plugins/org.eclipse.jdt.compiler.tool_1.0.101.v20120522-1651.jar:/usr/lib/eclipse/plugins/org.spoofax.interpreter.core_1.2.0.201308190125.jar:/usr/lib/eclipse/plugins/org.spoofax.interpreter.library.jsglr_1.2.0.201308190125.jar:/usr/lib/eclipse/plugins/org.spoofax.interpreter_1.2.0.201308190125.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/common/bin:/usr/lib/eclipse/plugins/org.sugarj.languagelib_1.0.0.201308291448.jar:/usr/lib/eclipse/plugins/org.strategoxt.imp.generator_1.2.0.201308190125/dist/sdf2imp.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/compiler/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/java/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/compiler/lib/commons-cli-1.2.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/compiler/lib/commons-collections-3.2.1.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/compiler/lib/make_permissive.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/compiler/lib/org.eclipse.core.resources_3.8.1.v20120802-154922.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/compiler/lib/org.strategoxt.imp.debug.core_1.2.0.201308190125.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/data-generation/lib/javacsv.jar"

PROJECTS_PATH='/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/case-studies'
DATA_PATH='/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/data-generation/data'
SRC='src'
BIN='bin'

NUM_EXEC=1

#################

#NAME='all'
#FILES='test/TestAll.sugj test/TestClosureXML.sugj test/TestPairXML.sugj test/TestXML.sugj test/TestPair.sugj test/TestClosure.sugj test/Partial.sugj'

NAME='xml'
FILES='xml/Test.sugj'

#NAME='closures'
#FILES='javaclosure/Test.sugj'

#NAME='pairs'
#FILES='pair/TestPair.sugj'

PROJECT="$PROJECTS_PATH/$NAME"
OUTPUT="$DATA_PATH/$NAME/$NAME"

if [ -e $DATA_PATH ]
then
  echo "dir $DATA_PATH already exists."
else
  echo "creating dir $DATA_PATH"
  mkdir $DATA_PATH
fi

if [ -e "$DATA_PATH/$NAME" ]
then
  echo "dir $DATA_PATH/$NAME already exists."
else
  echo "creating dir $DATA_PATH/$NAME"
  mkdir "$DATA_PATH/$NAME"
fi

count=0
until [ $count = $NUM_EXEC ]
do
  count=`expr $count + 1`
  java -Xss64m -Xmx1024m -classpath $CP_PATH sugarj.DataGeneration '--sourcepath' "$PROJECT/$SRC" '--binpath' "$PROJECT/$BIN" '-o' "$OUTPUT$count" $FILES
  rm -rf "$PROJECT/$BIN"
  rm -rf /tmp/sugarj* /tmp/SugarJ* /tmp/.sugarjcache
  sleep 120
done

#java -classpath $CP_PATH sugarj.SumaryData -i "$DATA_PATH/$NAME" 'pair/Pair.sugj' 'xml/XmlSyntax.sugj' 'javaclosure/Syntax.sugj' 'test/TestPair.sugj' 'test/TestXML.sugj' 'test/TestClosure.sugj' 'test/Partial.sugj test/TestPairXML.sugj test/TestClosureXML.sugj test/TestAll.sugj'
java -classpath $CP_PATH sugarj.SumaryData -i "$DATA_PATH/$NAME" 'xml/Test.sugj' 'xml/XmlSyntax.sugj'
#java -classpath $CP_PATH sugarj.SumaryData -i "$DATA_PATH/$NAME" 'javaclosure/Test.sugj' 'javaclosure/Syntax.sugj'
#java -classpath $CP_PATH sugarj.SumaryData -i "$DATA_PATH/$NAME" 'pair/TestPair.sugj' 'pair/Pair.sugj'

echo 'end'




