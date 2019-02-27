#!/bin/bash

if [ $# -lt 5 ]
then
    echo "
 Syntax:
      $0 <bintray-user> <bintray-apikey> <bintray-repo-owner> <bintray-reponame> <bintray-packagename> <bintray-packageversion>>
 Example:
      $0 user1 A1098765 my-bintray-org my-bintray-repo1 my-bintray-package 0.0.1
"

 exit 1
fi

user=$1
apikey=$2
subject=$3
reponame=$4
pkgname=$5
pkgversion=$6

#set -x

urlstring="https://api.bintray.com/maven_central_sync/${subject}/${reponame}/${pkgname}/versions/${pkgversion}"

basicauth="${user}:${apikey}"

echo "
Executing curl command..."
curl -X POST --data '{ "close": "1" }' -H "Content-Type: application/json" -L -k --user ${basicauth} ${urlstring}
