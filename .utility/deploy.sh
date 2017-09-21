#!/usr/bin/env bash

if [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
  openssl aes-256-cbc -K $encrypted_3faf32fc672a_key -iv $encrypted_3faf32fc672a_iv -in .utility/cd/secring.gpg.enc -out .utility/cd/secring.gpg -d
  ./gradlew uploadArchives -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=$KEYRING_PATH -PossrhUsername=$OSSRH_JIRA_USERNAME -PossrhPassword=$OSSRH_JIRA_PASSWORD
fi
