#!/bin/sh

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	echo '$TRAVIS_PULL_REQUEST is false, running unit tests'
	mvn clean install -Dmaven.test.skip=true && mvn clean test
else
	echo '$TRAVIS_PULL_REQUEST is not false ($TRAVIS_PULL_REQUEST), running integration tests'
	mvn clean install -Dmaven.test.skip=true && mvn clean verify cobertura:cobertura-integration-test coveralls:report
  codecov
fi
