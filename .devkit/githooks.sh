#!/usr/bin/env sh

pwd
cp ../.cicd/githooks/* ../.git/hooks/ || cp .cicd/githooks/* .git/hooks/
