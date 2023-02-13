#!/bin/bash

cFile=inject.c
exeFile=inject
jar=hadoop-hdfs-3.1.2.jar
tar=hadoop-3.1.2.tar.gz
system=hadoop-3.1.2

if [ -f $injectFile ]
then
    gcc $cFile -o $exeFile
    echo "gcc compile success"
    ./$exeFile
else
  echo "Error: $cFile not found !"
fi

cd ../hadoop-hdfs-project/hadoop-hdfs/
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/$jar ../../../

cd ../../../
echo "current working directory: `pwd`"
rm -rf $tar
cp ./$jar ./$system/share/hadoop/hdfs/
tar -zcvf $tar $system
rm -rf $jar
