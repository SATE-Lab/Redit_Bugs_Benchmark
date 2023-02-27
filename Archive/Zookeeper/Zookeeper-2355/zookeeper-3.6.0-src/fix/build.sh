#!/bin/bash

tar=apache-zookeeper-3.6.0-bin.tar.gz
system=apache-zookeeper-3.6.0-bin

cd ..
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./zookeeper-assembly/target/$tar ../

cd ..
tar -zxvf $tar
tar -zcvf $tar $system
rm -rf $system
