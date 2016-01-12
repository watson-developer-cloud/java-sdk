#!/bin/bash

if [ "$TRAVIS_REPO_SLUG" == "watson-developer-cloud/java-sdk" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" ] && [ "$TRAVIS_BUILD_NUMBER.1" == "$TRAVIS_JOB_NUMBER" ]; then

  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"
  git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/watson-developer-cloud/java-sdk gh-pages > /dev/null

  pushd gh-pages
    echo "current dir"
    pwd
    # on tagged builds, $TRAVIS_BRANCH is the tag (e.g. v1.2.3), otherwise it's the branch name (e.g. master)
    rm -rf docs/$TRAVIS_BRANCH
    mkdir -p docs/$TRAVIS_BRANCH

    cp -rf ../target/site/apidocs/* docs/$TRAVIS_BRANCH

    ../.utility/generate_index_html.sh > index.html

    git add -f .
    git commit -m "Latest javadoc for $TRAVIS_BRANCH ($TRAVIS_COMMIT)"
    git push -fq origin gh-pages > /dev/null

  popd

  echo -e "Published Javadoc for build $TRAVIS_BUILD_NUMBER ($TRAVIS_JOB_NUMBER) on branch $TRAVIS_BRANCH.\n"

else

  echo -e "Not publishing docs for build $TRAVIS_BUILD_NUMBER ($TRAVIS_JOB_NUMBER) on branch $TRAVIS_BRANCH of repo $TRAVIS_REPO_SLUG"

fi
