#!/bin/bash

# This script will publish the aggregated javadocs found in the project's "target" directory.
# The javadocs are committed and pushed to the git repository's gh-pages branch.
# Be sure to customize this file to reflect your SDK project's settings (git url, 

export GHA_BRANCH=${GHA_BRANCH##*/}    # Get the last part for true branch name - "refs/heads/9260_gha"
# Avoid publishing javadocs for a PR build
if [ "$GHA_PULL_REQUEST" == "false" ] && [ "$GHA_BRANCH" ]; then
    printf "\n>>>>> Publishing javadoc for release build: repo=%s branch=%s build_num=%s job_num=%s pr=%s tag=%s commit=%s\n" ${GHA_REPO_SLUG} ${GHA_BRANCH} ${GHA_BUILD_NUMBER} ${GHA_JOB_NUMBER} ${GHA_PULL_REQUEST} ${GHA_TAG} ${GHA_COMMIT}

    printf "\n>>>>> Cloning repository's gh-pages branch into directory 'gh-pages'\n"
    rm -fr ./gh-pages
    git clone --branch=gh-pages https://${GH_TOKEN}@github.com/watson-developer-cloud/java-sdk.git gh-pages > /dev/null

    printf "\n>>>>> Finished cloning...\n"

    pushd gh-pages
    
    # Create a new directory for this branch/tag and copy the aggregated javadocs there.
    printf "\n>>>>> Copying aggregated javadocs to new tagged-release directory: %s\n" ${GHA_BRANCH}
    rm -rf docs/${GHA_BRANCH}
    mkdir -p docs/${GHA_BRANCH}
    cp -rf ../target/site/apidocs/* docs/${GHA_BRANCH}

    printf "\n>>>>> Generating gh-pages index.html...\n"
    ../build/generateJavadocIndex.sh > index.html

    # Update the 'latest' symlink to point to this branch if it's a tagged release.
    if [ -n "$GHA_TAG" ]; then
	      pushd docs
	      rm latest
	      ln -s ./${GHA_TAG} latest
	      printf "\n>>>>> Updated 'docs/latest' symlink:\n"
	      ls -l latest
	      popd
    fi

    printf "\n>>>>> Committing new javadoc...\n"
    git add -f .
    git commit -m "Javadoc for release ${GHA_TAG} (${GHA_COMMIT})"
    git push -f origin gh-pages

    popd

    printf "\n>>>>> Published javadoc for release build: repo=%s branch=%s build_num=%s job_num=%s\n"  ${GHA_REPO_SLUG} ${GHA_BRANCH} ${GHA_BUILD_NUMBER} ${GHA_JOB_NUMBER}

else

    printf "\n>>>>> Javadoc publishing bypassed for non-release build: repo=%s branch=%s build_num=%s job_num=%s pr=%s tag=%s commit=%s\n" ${GHA_REPO_SLUG} ${GHA_BRANCH} ${GHA_BUILD_NUMBER} ${GHA_JOB_NUMBER} ${GHA_PULL_REQUEST} ${GHA_TAG} ${GHA_COMMIT}

fi
