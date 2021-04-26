#!/bin/bash
set -o pipefail

openssl aes-256-cbc -K $encrypted_99a33d910092_key -iv $encrypted_99a33d910092_iv -in .utility/secring.gpg.enc -out .utility/secring.gpg -d
./gradlew uploadArchives -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=./scripts/secring.gpg &

# output every 9 min to prevent a Travis timeout
PID=$!
while [[ $(ps -p $PID | tail -n +2) ]]; do
  echo 'Deploying...'
  sleep 540
done
