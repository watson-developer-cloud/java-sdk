#!/usr/bin/env bash
#if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_bdb9d73a7940_key -iv $encrypted_bdb9d73a7940_iv -in cd/secring.gpg.enc -out cd/secring.gpg -d
    ls -l cd
    ./gradlew signJars -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=$KEYRING_PATH -PossrhUsername=$OSSRH_JIRA_USERNAME -PossrhPassword=$OSSRH_JIRA_PASSWORD
#fi