from sys import argv
from tempfile import mkstemp
from shutil import move
from os import remove, close
# import os, fileinput

services = ["alchemy", "conversation", "dialog", "discovery", \
            "document-conversion", "language-translation", "language-translator",\
             "natural-language-classifier", "personality-insights", "retrieve-and-rank",\
             "speech-to-text", "text-to-speech", "tone-analyzer", "tradeoff-analytics",\
             "visual-recognition"]

print ("What's the current version of the snapshot? Please answer in format 0.0.0")
orig_version = raw_input("> ")
orig_version_string = "version = '%s-SNAPSHOT'" %orig_version
print ("What version would you like to release?")
new_version = raw_input("> ")
new_version_string = "version = '%s-SNAPSHOT'" %new_version

def replace(file_path, pattern, subst):
    # Create temp file_path
    fh, abs_path = mkstemp()
    found = False
    with open(abs_path, 'w') as new_file:
        with open(file_path) as old_file:
            for line in old_file:
                new_file.write(line.replace(pattern, subst))
                if pattern in line:
                    found = True
    if found:
        print "Updating version to %s for service: %s\n" %(subst, file_path)
        remove(file_path)
        move(abs_path, file_path)
    else:
        print "\nDid not find version specified. Please check which version you want to replace.\n"
    close(fh)
    return found

for service in services:
    file_path = "%s/build.gradle" %service
    success = replace(file_path, orig_version_string, new_version_string)
    if not success:
        break
