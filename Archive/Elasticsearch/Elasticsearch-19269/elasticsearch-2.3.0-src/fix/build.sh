#!/bin/bash

buildtar=elasticsearch-2.3.0-SNAPSHOT.tar.gz
tar=elasticsearch-2.3.0.tar.gz
buildsystem=elasticsearch-2.3.0-SNAPSHOT
system=elasticsearch-2.3.0

cd ..
echo "current working directory: `pwd`"
mvn clean package -DskipTests
cp ./distribution/tar/target/releases/$buildtar ../.

cd ..
tar zxvf $buildtar
mv $buildsystem $system
rm -rf $buildtar
tar -zcvf $tar $system
rm -rf $system
