#!/bin/bash

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	echo '$TRAVIS_PULL_REQUEST is false, running all tests'
	mvn clean integration-test
else
	echo '$TRAVIS_PULL_REQUEST is not false ($TRAVIS_PULL_REQUEST), running unit tests'
	mvn clean test
fi
# merge the unit test and integration test reports
mvn jacoco:merge