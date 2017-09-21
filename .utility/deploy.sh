#!/usr/bin/env bash

if [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
  openssl aes-256-cbc -K $encrypted_2a8b0f951653_key -iv $encrypted_2a8b0f951653_iv -in .utility/cd/secring.gpg.enc -out .utility/cd/secring.gpg -d
  ./gradlew uploadArchives -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=$KEYRING_PATH -PossrhUsername=$OSSRH_JIRA_USERNAME -PossrhPassword=$OSSRH_JIRA_PASSWORD
fi
