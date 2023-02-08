#!/bin/bash

cFile=inject.c
exeFile=inject
buildJar=apache-cassandra-2.2.16-SNAPSHOT.jar
libJar=apache-cassandra-2.2.16.jar
tar=apache-cassandra-2.2.16.tar.gz
system=apache-cassandra-2.2.16

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
