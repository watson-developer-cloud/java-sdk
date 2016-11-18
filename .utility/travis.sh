#!/bin/bash

set -e # enforces the script to fail as soon as one command fails

./gradlew install -x check
gradle docs > /dev/null

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
  echo '$TRAVIS_PULL_REQUEST is false, running all tests'
  openssl aes-256-cbc -K $encrypted_a973fe4f8e79_key -iv $encrypted_a973fe4f8e79_iv -in .config.properties.enc -out tests/src/test/resources/.config.properties -d
  ./gradlew cobertura
else
  echo '$TRAVIS_PULL_REQUEST is not false ($TRAVIS_PULL_REQUEST), running unit tests'
  ./gradlew check
fi
