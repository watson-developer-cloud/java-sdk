set -o pipefail

if [ "${TRAVIS_EVENT_TYPE}" == "push"  ] && [ "${TRAVIS_BRANCH}" != "master" ] && [ "${TRAVIS_TAG}" != "${TRAVIS_BRANCH}" ]; then
  if test -f "common/src/test/resources/config.properties"; then
    echo "Running integration tests"
  fi
  ./gradlew codeCoverageReport --continue
fi