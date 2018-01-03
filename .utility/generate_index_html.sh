#!/bin/sh

# based on https://odoepner.wordpress.com/2012/02/17/shell-script-to-generate-simple-index-html/

echo '<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBM Watson Developer Cloud</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>IBM Watson Developer Cloud Java SDK</h1>
    </div>

    <p><a href="https://www.ibm.com/watson/developer/">Info</a>
        | <a href="https://console.bluemix.net/developer/watson/documentation">Documentation</a>
        | <a href="https://github.com/watson-developer-cloud/java-sdk">GitHub</a>
        | <a href="http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.ibm.watson.developer_cloud%22%20a%3A%22java-sdk%22">Maven</a>
    </p>

    <p>Javadoc by branch/tag:</p>
    <ul>'
ls docs | grep --invert-match index.html | sed 's/^.*/<li><a href="docs\/&">&<\/a><\/li>/'
echo '    </ul>
</div>
<script>
    (function(i,s,o,g,r,a,m){i["GoogleAnalyticsObject"]=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,"script","//www.google-analytics.com/analytics.js","ga");
    ga("create", "UA-59827755-4", "auto");
    ga("send", "pageview");
</script>
</body>
</html>'
