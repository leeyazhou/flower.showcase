#!/bin/bash
echo "start flower"

flowerHome=$(cd "../$(dirname "$0")";pwd)
flowerLibs="${flowerHome}/libs"

echo "flowerHome : ${flowerHome}"
echo "flowerLibs : ${flowerLibs}"

classpath=$classpath
for jar in ${flowerLibs}/*; do 
	classpath="$classpath:$jar"
done

java -classpath  $classpath -Dspring.config.location=conf/spr.xml com.ly.train.flower.container.Bootstrap

