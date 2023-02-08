#!/bin/bash

cFile=inject.c
exeFile=inject
buildJar=apache-cassandra-3.11.6-SNAPSHOT.jar
libJar=apache-cassandra-3.11.6.jar
tar=apache-cassandra-3.11.6.tar.gz
system=apache-cassandra-3.11.6

if [ -f $injectFile ]
then
    gcc $cFile -o $exeFile
    echo "gcc compile success"
    ./$exeFile
else
  echo "Error: $cFile not found !"
fi

cd ..
echo "current working directory: `pwd`"
ant

cp ./build/$buildJar ../
cd ..
rm -rf $libJar $tar
mv $buildJar $libJar
cp $libJar ./$system/lib/
tar -zcvf $tar $system
rm -rf $libJar
