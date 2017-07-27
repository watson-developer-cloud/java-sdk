#!/usr/bin/env bash

if [ "$TRAVIS_REPO_SLUG" == "watson-developer-cloud/java-sdk" ] && \
   [ "$TRAVIS_JDK_VERSION" == "oraclejdk7" ] && \
   [ "$TRAVIS_PULL_REQUEST" == "false" ] && \
   [ "$TRAVIS_BRANCH" == "master" ]; then
  openssl aes-256-cbc -K $encrypted_bdb9d73a7940_key -iv $encrypted_bdb9d73a7940_iv -in .utility/cd/secring.gpg.enc -out .utility/cd/secring.gpg -d
  ./gradlew uploadArchives -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=$KEYRING_PATH -PossrhUsername=$OSSRH_JIRA_USERNAME -PossrhPassword=$OSSRH_JIRA_PASSWORD
fi
