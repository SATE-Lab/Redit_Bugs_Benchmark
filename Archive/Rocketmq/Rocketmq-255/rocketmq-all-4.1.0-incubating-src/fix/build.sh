#!/bin/bash

cFile=inject.c
exeFile=inject
buildJar=rocketmq-client-4.1.0-incubating.jar
libJar=rocketmq-client-4.2.0-incubating-SNAPSHOT.jar
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

cd ../client
echo "current working directory: `pwd`"
mvn -DskipTests clean install

cp ./target/$buildJar ../../
cd ..
cd ..
rm -rf $libJar $tar
mv $buildJar $libJar
cp $libJar ./$system/lib/
tar -zcvf $tar $system
rm -rf $libJar
