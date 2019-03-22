#!/bin/bash

cd ../../../

if [ "$JAVA_HOME" = "" ]; then
  echo "Error: JAVA_HOME environment variable is not set."
  exit 1
fi

$JAVA_HOME/bin/java -jar target/jsr-talk-1.0.0.BUILD-SNAPSHOT.jar logAnalysisWithSpring inputFile=/tmp/jsr_temp/swk_small.log stagingDirectory=/tmp/jsr_temp/out/
