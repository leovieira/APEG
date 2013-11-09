#!/bin/bash

CP_PATH=".:/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/data-generation/bin:/home/leo/workspace/APEG/experiments/data-analyses/bin:/home/leo/workspace/APEG/experiments/data-analyses/lib/javacsv.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/compiler/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/compiler/lib/*:/home/leo/workspace/APEG/project/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/common/bin"

PROJECTS_PATH='/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/case-studies'
DATA_PATH='/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/data-generation/data'
SRC='src'
BIN='bin'

NUM_EXEC=30

#################

NAME='all'
FILES='test/TestAll.sugj test/TestClosureXML.sugj test/TestPairXML.sugj test/TestXML.sugj test/TestPair.sugj test/TestClosure.sugj test/Partial.sugj'


#NAME='xml'
#FILES='xml/Test.sugj'

#NAME='closures'
#FILES='javaclosure/Test.sugj'

#NAME='pairs'
#FILES='pair/TestPair.sugj'

####
#NAME='n-pairs'
#FILES='test/Test01.sugj test/Test02.sugj test/Test03.sugj test/Test04.sugj test/Test05.sugj test/Test06.sugj test/Test07.sugj test/Test08.sugj test/Test09.sugj test/Test10.sugj test/Test11.sugj test/Test12.sugj test/Test13.sugj test/Test14.sugj test/Test15.sugj test/Test16.sugj test/Test17.sugj test/Test18.sugj test/Test19.sugj test/Test20.sugj'

#NAME='n-closures'
#FILES='test/Test01.sugj test/Test02.sugj test/Test03.sugj test/Test04.sugj test/Test05.sugj test/Test06.sugj test/Test07.sugj test/Test08.sugj test/Test09.sugj test/Test10.sugj test/Test11.sugj test/Test12.sugj test/Test13.sugj test/Test14.sugj test/Test15.sugj test/Test16.sugj test/Test17.sugj test/Test18.sugj test/Test19.sugj test/Test20.sugj'

#NAME='n-xml'
#FILES='test/Test01.sugj test/Test02.sugj test/Test03.sugj test/Test04.sugj test/Test05.sugj test/Test06.sugj test/Test07.sugj test/Test08.sugj test/Test09.sugj test/Test10.sugj'

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

count=1
java -Xss64m -Xmx1024m -classpath $CP_PATH apeg.Main '--sourcepath' "$PROJECT/$SRC" '-o' "$OUTPUT" $FILES
sleep 20
until [ $count = $NUM_EXEC ]
do
  count=`expr $count + 1`
  java -Xss64m -Xmx1024m -classpath $CP_PATH apeg.Main '--sourcepath' "$PROJECT/$SRC" '-o' "$OUTPUT" '--append' $FILES
  sleep 20
done

echo 'end'




