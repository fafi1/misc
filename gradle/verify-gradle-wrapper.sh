#!/usr/bin/env bash

WRAPPER_VERSION=$1

curl --location --output gradle-wrapper.jar.sha256 \
       https://services.gradle.org/distributions/gradle-$WRAPPER_VERSION-wrapper.jar.sha256
echo "  gradle-wrapper.jar" >> gradle-wrapper.jar.sha256
sha256sum --check gradle-wrapper.jar.sha256
