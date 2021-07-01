#!/bin/bash

# This script will check $GHA_TAG to see if we need to run maven to
# set the artifact version #'s.
export GHA_TAG=${GHA_TAG##*/}    # Get the last part for true tag name - "refs/heads/9260_gha"

if [[ -n "${GHA_TAG}" ]]; then
    printf "\n>>>>> Setting artifact version #'s to: %s\n" ${GHA_TAG:1}
    mvn versions:set -DnewVersion=${GHA_TAG:1} -DgenerateBackupPoms=false
else
    printf "\n>>>>> Bypassing artifact version setting for non-tagged build %s\n" ${GHA_TAG:1}
fi
     