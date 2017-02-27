from sys import argv
from tempfile import mkstemp
from shutil import move
from os import remove, close

print("Make sure you're in the root directory when running the script.")
print("The command you ran should have been `python .utility/update_snapshot_version.py`.\n")

services = ["alchemy", "conversation", "dialog", "discovery", \
            "document-conversion", "language-translation", "language-translator",\
             "natural-language-classifier", "personality-insights", "retrieve-and-rank",\
             "speech-to-text", "text-to-speech", "tone-analyzer", "tradeoff-analytics",\
             "visual-recognition"]

print ("What's the current version of the snapshot? Please answer in format: 0.0.0")
orig_version = raw_input("> ")
orig_version_string = "version = '%s-SNAPSHOT'" %orig_version
print ("What version would you like to release?")
new_version = raw_input("> ")
new_version_string = "version = '%s-SNAPSHOT'" %new_version

""" 
Replace all mentions of the version pattern with the specified new version. 
file_path = file path to the file to find and replace pattern
pattern = pattern to scan for
subst = word to replace pattern with

Returns boolean if the pattern was replaced.
"""
def replace(file_path, pattern, subst):
    # Create temp file_path
    fh, abs_path = mkstemp()
    found = False
    with open(abs_path, 'w') as new_file:
        with open(file_path) as old_file:
            # Write each line into the temp file
            for line in old_file:
                # Replace line with the substituted word if pattern found
                new_file.write(line.replace(pattern, subst))
                if pattern in line:
                    found = True
    if found:
        # If pattern found, replace old file with the temp file that includes the
        # substitued word.
        print "Updating version to %s for service: %s\n" %(subst, file_path)
        remove(file_path)
        move(abs_path, file_path)
    else:
        # Otherwise, exit.
        print "\nDid not find version specified. Please check which version you want to replace.\n"
    close(fh)
    return found

# For each service, replace the line defining release version.
for service in services:
    file_path = "%s/build.gradle" %service
    success = replace(file_path, orig_version_string, new_version_string)
    if not success:
        break
