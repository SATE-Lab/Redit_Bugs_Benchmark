#!/bin/bash

cFile=inject.c
exeFile=inject
buildJar1=rocketmq-client-4.1.0-incubating.jar
buildJar2=rocketmq-common-4.1.0-incubating.jar
libJar1=rocketmq-client-4.2.0-incubating-SNAPSHOT.jar
libJar2=rocketmq-common-4.2.0-incubating-SNAPSHOT.jar
tar=rocketmq-4.1.0-incubating.tar.gz
system=rocketmq-4.1.0-incubating

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
rm -rf $libJar1 $libJar2 $tar
mv $buildJar1 $libJar1
mv $buildJar2 $libJar2
cp $libJar1 ./$system/lib/
cp $libJar2 ./$system/lib/
tar -zcvf $tar $system
