#!/bin/bash

set -e

VERSION="patch"

if [ "${TRAVIS_BRANCH}" != "master" ]; then
  VERSION="rc"
fi

bumpversion  --current-version $1 --new-version $2 --allow-dirty $VERSION --verbose