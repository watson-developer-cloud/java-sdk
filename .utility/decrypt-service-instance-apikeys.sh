#!/bin/bash
if [ "$TRAVIS_PULL_REQUEST" == "false" ]; then
  echo -e "Decrypt service instance apikeys for branch $TRAVIS_BRANCH.\n"
  openssl aes-256-cbc -K $encrypted_42d9c68e608d_key -iv $encrypted_42d9c68e608d_iv -in secrets.tar.enc -out secrets.tar -d
  tar xvf secrets.tar
else
  echo -e "Not Decrypt service instance apikeys for branch $TRAVIS_BRANCH.\n"
fi