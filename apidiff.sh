#!/bin/bash
# Author: Hanbin Cho (mraerok@gmail.com)
# Assumptions
# 1. This script is placed in the project root of java-sdk.
# 2. Version format is [0-9].[0-9].[0-9]

# Step 1: Download the latest release of java-sdk published in Maven Repository.
mvn dependency:get \
 -DgroupId=com.ibm.watson.developer_cloud \
 -DartifactId=java-sdk \
 -Dversion=LATEST \
 -Dpackaging=jar \
 -Dclassifier=jar-with-dependencies \
 -Dtransitive=false

# Step 2: Construct the filepath to the latest release of java-sdk.
LOCAL_MAVEN_REPO_PATH="${HOME}/.m2/repository"
RELEASE_JAR_BASEPATH="${LOCAL_MAVEN_REPO_PATH}/com/ibm/watson/developer_cloud/java-sdk"
pushd $RELEASE_JAR_BASEPATH
LATEST_RELEASE_VERSION=`ls | grep -d read "[0-9]\.[0-9]\.[0-9]" | sort | tail -n 1`
LATEST_RELEASE_JAR_FILENAME="java-sdk-${LATEST_RELEASE_VERSION}-jar-with-dependencies.jar"
LATEST_RELEASE_JAR_PATH="${RELEASE_JAR_BASEPATH}/${LATEST_RELEASE_VERSION}/${LATEST_RELEASE_JAR_FILENAME}"

# Step 3: Validate the filepath to the latest release of java-sdk.
if [ ! -f $LATEST_RELEASE_JAR_PATH ]; then
    echo "apidiff.sh: Latest release jar was not at its expected location at: $LATEST_RELEASE_JAR_PATH"
    popd
    exit 1
fi
popd

# Step 4: Generate a stand-alone jar of the current version of java-sdk.
./gradlew shadowJar

# Step 5: Construct the filepath to the current version of java-sdk.
CURRENT_VERSION=`cat gradle.properties | grep "version=[0-9]\.[0-9]\.[0-9]" | cut -d '=' -f 2`
CURRENT_JAR_FILENAME="java-sdk-${CURRENT_VERSION}-jar-with-dependencies.jar"
CURRENT_JAR_BASEPATH="java-sdk/build/libs"
CURRENT_JAR_PATH="${CURRENT_JAR_BASEPATH}/${CURRENT_JAR_FILENAME}"

# Step 6: Validate the filepath to the current version of java-sdk.
if [ ! -f $CURRENT_JAR_PATH ]; then
    echo "apidiff.sh: Current jar was not at its expected location at: $CURRENT_JAR_PATH"
    exit 1
fi

# Step 7: Produce an API diff between the latest release and the current version using japicmp module.
# TODO: Figure out how to set japicmp task's properties (oldClasspath and newClasspath) through command-line invocation.
./gradlew japicmp -PoldJarPath="${LATEST_RELEASE_JAR_PATH}" -PnewJarPath="${CURRENT_JAR_PATH}" -PoldJarVersion="${LATEST_RELEASE_VERSION}" -PnewJarVersion="${CURRENT_VERSION}"

# Step 8: Construct the filepath to the produced API diff.

# Step 9: Upload the API diff to java-sdk documentation page.
