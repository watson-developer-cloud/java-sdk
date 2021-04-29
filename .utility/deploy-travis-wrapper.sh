#!/bin/bash
set -o pipefail

openssl aes-256-cbc -K $encrypted_6afd0fc9428e_key -iv $encrypted_6afd0fc9428e_iv -in .utility/secring.gpg.enc -out .utility/secring.gpg -d
./gradlew uploadArchives -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=../.utility/secring.gpg &

# output every 9 min to prevent a Travis timeout
PID=$!
while [[ $(ps -p $PID | tail -n +2) ]]; do
  echo 'Deploying...'
  sleep 540
done
