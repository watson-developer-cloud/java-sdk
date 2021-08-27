#!/usr/bin/env bash
set -x

# This script is responsible for decrypting your encrypted signing key file
# (build/signing.key.enc), and importing it into the gpg keystore.
# This is done so that your maven build will be able to properly sign your jars
# prior to publishing them on maven central.

echo "Importing signing key..."

# Modify the command below to use the correct environment variables
# that were added to your Travis build settings when you encrypted your signing.key file.
gpg --quiet --batch --yes --decrypt --passphrase="$SIGNING_PASSPHRASE" --output ./build/signing.key ./build/signing.key.gpg

# export GPG_TTY=$(tty)
gpg --version
gpg --fast-import ./build/signing.key
rm ./build/signing.key

echo "Signing key import finished!"
