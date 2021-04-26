#!/bin/bash
if [ "$TRAVIS_PULL_REQUEST" == "false" ]; then
  echo -e "Decrypt service instance apikeys for branch $TRAVIS_BRANCH.\n"
  openssl aes-256-cbc -K $encrypted_b3aab48b571a_key -iv $encrypted_b3aab48b571a_iv \
  -in config.properties.enc -out common/src/test/resources/config.properties -d
else
  echo -e "Not Decrypt service instance apikeys for branch $TRAVIS_BRANCH.\n"
fi