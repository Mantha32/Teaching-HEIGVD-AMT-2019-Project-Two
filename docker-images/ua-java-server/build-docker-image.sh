#!/bin/bash

mkdir tmp

mvn clean package -f ../../microservices/ua-server/pom.xml
cp ../../microservices/ua-server/target/java-server*.jar ./tmp/

docker build -t openaffect/java-server .
