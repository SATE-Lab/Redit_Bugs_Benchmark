#!/bin/bash

cFile=inject.c
exeFile=inject
tgz=kafka_2.13-2.8.0.tgz
tar=kafka_2.13-2.8.0.tar.gz
system=kafka_2.13-2.8.0

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
./gradlew clean releaseTarGz -x signArchives
cp ./core/build/distributions/$tgz ../

cd ..
tar -zxvf $tgz
rm -rf $tar
tar -zcvf $tar $system
rm -rf $system $tgz
