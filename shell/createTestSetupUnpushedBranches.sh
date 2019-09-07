#!/usr/bin/env bash

TEST_DIR=$(pwd)/findUnpushedBranchesTest
LOCAL_REPO=${TEST_DIR}/testRepo
REMOTE_REPO=${TEST_DIR}/testRepo.git

echo base dir: ${TEST_DIR}

mkdir -p ${REMOTE_REPO}
cd ${REMOTE_REPO}
git init --bare

cd ${TEST_DIR}
git clone ${REMOTE_REPO}
cd ${LOCAL_REPO}

## create setup
echo "first file" > file1.txt
git add --all && git commit -m 'test1'
git push origin master
git checkout -b master2
echo "some change" >> file1.txt
git commit --all -m 'test2'
git push -u origin master2:master
echo "some other change" >> file1.txt
git commit --all -m 'test3'
git checkout -b master3
git push origin master3
git checkout -b master4
git push -u origin master4

echo ### finished test setup ###
echo
echo

## show info branches
BRANCH=master
echo "git status porcelain $BRANCH:"
git checkout $BRANCH
git status --porcelain -b

BRANCH=master2
echo "git status porcelain $BRANCH:"
git checkout $BRANCH
git status --porcelain -b

BRANCH=master3
echo "git status porcelain $BRANCH:"
git checkout $BRANCH
git status --porcelain -b

BRANCH=master4
echo "git status porcelain $BRANCH:"
git checkout $BRANCH
git status --porcelain -b