#!/bin/bash

cFile=inject.c
exeFile=inject
jar=hbase-server-2.2.2.jar
tar=hbase-2.2.2.tar.gz
system=hbase-2.2.2

if [ -f $injectFile ]
then
    gcc $cFile -o $exeFile
    echo "gcc compile success"
    ./$exeFile
else
  echo "Error: $cFile not found !"
fi

cd ../hbase-server/
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/$jar ../../

cd ../../
echo "current working directory: `pwd`"
rm -rf $tar
cp ./$jar ./$system/lib/
tar -zcvf $tar $system
rm -rf $jar
