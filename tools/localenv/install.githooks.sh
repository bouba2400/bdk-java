#!/usr/bin/env sh

git config core.hooksPath ".githooks"

# get script dir
sdir=$(dirname "$0")
cwdir=$(pwd)

# stash cwd if different from script dir
if [ "$sdir" != "$cwdir" ]; then
  cd "$sdir" || exit 1
fi

# make hooks executable
chmod +x ../../.githooks/*

# restore cwd if different from script dir
if [ "$sdir" != "$cwdir" ]; then
  cd "$cwdir" || exit 1
fi
