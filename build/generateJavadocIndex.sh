#!/bin/sh

# based on https://odoepner.wordpress.com/2012/02/17/shell-script-to-generate-simple-index-html/

echo '<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBM Watson Developer Cloud</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>IBM Watson Developer Cloud Java SDK</h1>
    </div>

    <p><a href="https://www.ibm.com/watson/developer/">Info</a>
        | <a href="https://cloud.ibm.com/developer/watson/documentation">Documentation</a>
        | <a href="https://github.com/watson-developer-cloud/java-sdk">GitHub</a>
        | <a href="https://search.maven.org/search?q=g:com.ibm.watson">Maven</a>
    </p>

    <p>Javadoc by branch/release:</p>
    <ul><li><a href="docs/latest">Latest</a></li>'
ls docs | grep --invert-match index.html | sed 's/^.*/<li><a href="docs\/&">&<\/a><\/li>/'
echo '    </ul>
</div>
</body>
</html>'
