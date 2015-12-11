#!/bin/sh

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	echo '$TRAVIS_PULL_REQUEST is false, running all tests'
	mvn clean install -Dmaven.test.skip=true
	mvn clean verify cobertura:cobertura-integration-test coveralls:report
  codecov
else
	echo '$TRAVIS_PULL_REQUEST is not false ($TRAVIS_PULL_REQUEST), running unit tests'
	mvn clean install -Dmaven.test.skip=true
	mvn clean test
fi
