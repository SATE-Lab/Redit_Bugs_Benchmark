#!/bin/bash

cFile=inject.c
exeFile=inject
buildJar1=rocketmq-client-4.0.0-incubating.jar
buildJar2=rocketmq-common-4.0.0-incubating.jar
tar=rocketmq-4.0.0-incubating.tar.gz
system=rocketmq-4.0.0-incubating

if [ -f $injectFile ]
then
    gcc $cFile -o $exeFile
    echo "gcc compile success"
    ./$exeFile
else
  echo "Error: $cFile not found !"
fi

cd ../common
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/$buildJar2 ../../

cd ../client
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/$buildJar1 ../../

cd ..
cd ..
rm -rf $buildJar1 $buildJar2 $tar
cp $buildJar1 ./$system/lib/
cp $buildJar2 ./$system/lib/
tar -zcvf $tar $system
rm -rf $buildJar1 $buildJar2
