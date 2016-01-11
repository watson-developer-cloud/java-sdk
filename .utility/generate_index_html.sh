#!/bin/sh

# based on https://odoepner.wordpress.com/2012/02/17/shell-script-to-generate-simple-index-html/

echo '<!DOCTYPE html><html><body>'
echo '<h1>IBM Watson Developer Cloud Java SDK</h1>'
echo '<p><a href="https://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/doc/">Documentation</a>'
echo ' | <a href="https://github.com/watson-developer-cloud/java-sdk">GitHub</a>'
echo '</p>'
echo '<p>Javadoc by branch/tag:</p><ul>'
ls | grep --invert-match index.html | sed 's/^.*/<li><a href="javadoc/&">&<\/a><\/li>/'
echo '</ul></body></html>'
