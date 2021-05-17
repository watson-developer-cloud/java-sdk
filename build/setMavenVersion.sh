#!/bin/bash

# This script will check $TRAVIS_TAG to see if we need to run maven to
# set the artifact version #'s.

if [[ -n "${TRAVIS_TAG}" ]]; then
    printf "\n>>>>> Setting artifact version #'s to: %s\n" ${TRAVIS_TAG:1}
    mvn versions:set -DnewVersion=${TRAVIS_TAG:1} -DgenerateBackupPoms=false
else
    printf "\n>>>>> Bypassing artifact version setting for non-tagged build\n"
fi
     