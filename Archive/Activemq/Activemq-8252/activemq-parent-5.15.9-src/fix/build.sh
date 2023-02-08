#!/bin/bash

cFile=inject.c
exeFile=inject
libJar1=activemq-all-5.15.9.jar
libJar2=activemq-broker-5.15.9.jar
tar=activemq-5.15.9.tar.gz
system=activemq-5.15.9

if [ -f $injectFile ]
then
    gcc $cFile -o $exeFile
    echo "gcc compile success"
    ./$exeFile
else
  echo "Error: $cFile not found !"
fi

cd ../activemq-all
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/$libJar1 ../../

cd ../activemq-broker
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/$libJar2 ../../

cd ..
cd ..
cp $libJar1 ./$system/mq1/
cp $libJar1 ./$system/mq2/
cp $libJar1 ./$system/mq3/
cp $libJar2 ./$system/mq1/lib/
cp $libJar2 ./$system/mq2/lib/
cp $libJar2 ./$system/mq3/lib/
tar -zcvf $tar $system
rm -rf $libJar1 $libJar2
