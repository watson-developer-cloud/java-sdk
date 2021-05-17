#!/bin/bash

# This script will publish code coverage info for a build of the main branch
# or a tagged release.

if [[ -n "${TRAVIS_TAG}" || "${TRAVIS_BRANCH}" == "main" && "${TRAVIS_PULL_REQUEST}" == "false" ]]; then
    printf ">>>>> Publishing code coverage info for branch: %s\n" ${TRAVIS_BRANCH}
    $HOME/codecov-bash.sh -s modules/coverage-reports/target/site/jacoco-aggregate -t $CODECOV_TOKEN
else
    printf ">>>>> Bypassing code coverage publish step for feature branch/PR build.\n"
fi
     
