#!/usr/bin/env bash

PREFIX_DELETE1=will-be-removed-12

echo delete first occurence of \'*-\' before \'12\' in \'$PREFIX_DELETE1\': ${PREFIX_DELETE1#*-}
echo delete everything before \'12\' in \'$PREFIX_DELETE1\': ${PREFIX_DELETE1##*-}

PREFIX_DELETE2=abcd

echo delete first 2 characters in \'$PREFIX_DELETE2\': ${PREFIX_DELETE2##??}

SUFFIX_DELETE1=12-will-be-removed

REPLACEME1=test
REPLACEME2=

echo replacements: ${REPLACEME1:-replaced}, ${REPLACEME2:-replaced}, ${REPLACEME2-replaced}, ${REPLACEME3-replaced}
echo REPLACEME3 not set: $REPLACEME3
echo replacements: ${REPLACEME1:=replaced}, ${REPLACEME2:=replaced}, ${REPLACEME2=replaced}, ${REPLACEME3=replaced}
echo replaceme3 set now because of \'=\' : $REPLACEME3
echo length: ${#REPLACEME1}