#!/bin/bash

if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
	echo '$TRAVIS_PULL_REQUEST is false, running all tests'
	mvn clean cobertura:cobertura-integration-test
else
	echo '$TRAVIS_PULL_REQUEST is not false ($TRAVIS_PULL_REQUEST), running unit tests'
	mvn clean test
fi