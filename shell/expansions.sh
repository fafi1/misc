#!/usr/bin/env bash

PREFIX_DELETE1=will-be-removed-12

echo delete everything before \'12\' in \'$PREFIX_DELETE1\': ${PREFIX_DELETE1##*-}

PREFIX_DELETE2=abcd

echo delete first 2 characters in \'$PREFIX_DELETE2\': ${PREFIX_DELETE2##??}
