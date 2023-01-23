#!/bin/bash

cFile=inject.c
exeFile=inject
tar=apache-zookeeper-3.7.1-bin.tar.gz
system=apache-zookeeper-3.7.1-bin

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
mvn -DskipTests clean install
cp ./zookeeper-assembly/target/$tar ../

cd ..
tar -zxvf $tar
tar -zcvf $tar $system
rm -rf $system
