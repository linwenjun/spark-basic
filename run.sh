#!/usr/bin/env bash

JAR_NAME=data-engineering-workshop-assembly-0.1.jar

sbt assembly
cp ./target/scala-2.11/$JAR_NAME ./jars

docker-compose exec spark bash -c "./bin/spark-submit --class workshop.wordcount.WordCount --master local[4] /jars/data-engineering-workshop-assembly-0.1.jar"
