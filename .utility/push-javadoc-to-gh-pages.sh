#!/bin/bash

if [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" ]; then

  git config --global user.email "wps@us.ibm.com"
  git config --global user.name "Watson Github Bot"
  git clone --quiet --branch=gh-pages https://${GITHUB_TOKEN_DOCS}@github.com/watson-developer-cloud/java-sdk.git gh-pages > /dev/null

  pushd gh-pages
    # on tagged builds, $TRAVIS_BRANCH is the tag (e.g. v1.2.3), otherwise it's the branch name (e.g. master)
    rm -rf docs/$TRAVIS_BRANCH
    mkdir -p docs/$TRAVIS_BRANCH

    cp -rf ../build/docs/all/* docs/$TRAVIS_BRANCH
    ../.utility/generate_index_html.sh > index.html

	# update the latest/ symlink
    # on tagged builds, $TRAVIS_TAG is set to the tag, but it's blank on regular builds, unlike $TRAVIS_BRANCH
    if [ $TRAVIS_TAG ]; then
      rm latest
      ln -s ./$TRAVIS_TAG latest
    fi

    git add -f .
    git commit -m "Latest javadoc for $TRAVIS_BRANCH ($TRAVIS_COMMIT)"
    git push -fq origin gh-pages > /dev/null

  popd

  echo -e "Published Javadoc for build $TRAVIS_BUILD_NUMBER ($TRAVIS_JOB_NUMBER) on branch $TRAVIS_BRANCH.\n"

else

  echo -e "Not publishing docs for build $TRAVIS_BUILD_NUMBER ($TRAVIS_JOB_NUMBER) on branch $TRAVIS_BRANCH of repo $TRAVIS_REPO_SLUG"

fi
