#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_914d35e8ba1f_key -iv $encrypted_914d35e8ba1f_iv -in cd/secring.gpg.enc -out cd/secring.gpg -d
    ./gradlew signJars -Psigning.keyId=$SIGNING_KEY -Psigning.password=$SIGNING_PASSWORD -Psigning.secretKeyRingFile=$KEYRING_PATH -PossrhUsername=$OSSRH_JIRA_USERNAME -PossrhPassword=$OSSRH_JIRA_PASSWORD
fi