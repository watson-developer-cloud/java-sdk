#!/bin/bash
set -o pipefail

./gradlew bintrayUpload &

# output every 9 min to prevent a Travis timeout
PID=$!
while [[ $(ps -p $PID | tail -n +2) ]]; do
  echo 'Deploying...'
  sleep 540
done
