#!/bin/bash

tgz=kafka_2.13-3.2.0.tgz
tar=kafka_2.13-3.2.0.tar.gz
system=kafka_2.13-3.2.0

cd ..
echo "current working directory: `pwd`"
./gradlew clean releaseTarGz
cp ./core/build/distributions/$tgz ../

cd ..
tar -zxvf $tgz
rm -rf $tar
tar -zcvf $tar $system
rm -rf $system $tgz
