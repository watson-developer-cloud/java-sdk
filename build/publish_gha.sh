#!/bin/bash

# This script will publish the aggregated javadocs found in the project's "target" directory.
# The javadocs are committed and pushed to the git repository's gh-pages branch.
# Be sure to customize this file to reflect your SDK project's settings

export GHA_TAG=${GHA_TAG##*/}    # Get the last part for true tag name - "refs/heads/vx.x.x"
printf "\n>>>>> Publishing javadoc for release build: %s\n" ${GHA_TAG}

printf "\n>>>>> Cloning repository's gh-pages branch into directory 'gh-pages'\n"
rm -fr ./gh-pages
git config --global user.email "watdevex@us.ibm.com"
git config --global user.name "watdevex"
git clone --branch=gh-pages https://${GH_TOKEN}@github.com/watson-developer-cloud/java-sdk.git gh-pages > /dev/null
printf "\n>>>>> Finished cloning...\n"

pushd gh-pages
    
# Create a new directory for this branch/tag and copy the aggregated javadocs there.
printf "\n>>>>> Copying aggregated javadocs to new tagged-release directory: %s\n" ${GHA_TAG}
rm -rf docs/${GHA_TAG}
mkdir -p docs/${GHA_TAG}
cp -rf ../target/site/apidocs/* docs/${GHA_TAG}

printf "\n>>>>> Generating gh-pages index.html...\n"
../build/generateJavadocIndex.sh > index.html

# Update the 'latest' symlink to point to this branch if it's a tagged release.
pushd docs
rm latest
ln -s ./${GHA_TAG} latest
printf "\n>>>>> Updated 'docs/latest' symlink:\n"
ls -l latest
popd

printf "\n>>>>> Committing new javadoc for commit: %s\n" ${GHA_COMMIT}
git add -f .
git commit -m "chore: Javadoc for release ${GHA_TAG} (${GHA_COMMIT})"
git push -f origin gh-pages

popd
