#!/usr/bin/env bash

# see: https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History

git filter-branch --commit-filter '
  GIT_AUTHOR_NAME="Fabian Fichter";
  GIT_AUTHOR_EMAIL="faficode@gmail.com";
  git commit-tree "$@";
' HEAD