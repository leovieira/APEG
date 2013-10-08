#!/bin/bash

CP_PATH=".:/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/data-generation/bin:/home/leo/workspace/APEG/experiments/data-analyses/bin:/home/leo/workspace/APEG/experiments/data-analyses/lib/javacsv.jar:/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/compiler/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/compiler/lib/*:/home/leo/workspace/APEG/project/bin:/home/leo/workspace/APEG/experiments/languages/SugarJ/orign/common/bin"

PROJECTS_PATH='/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/case-studies'
DATA_PATH='/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/data-generation/data'
SRC='src'
BIN='bin'

NUM_EXEC=30

#################

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




