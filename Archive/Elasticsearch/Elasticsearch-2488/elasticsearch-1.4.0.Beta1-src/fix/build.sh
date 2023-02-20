#!/bin/bash

tar=elasticsearch-1.4.0.Beta1.tar.gz
system=elasticsearch-1.4.0.Beta1

cd ..
echo "current working directory: `pwd`"
mvn -DskipTests clean install
cp ./target/releases/$tar ../.

cd ..
tar zxvf $tar
rm -rf $tar
tar -zcvf $tar $system
rm -rf $system
