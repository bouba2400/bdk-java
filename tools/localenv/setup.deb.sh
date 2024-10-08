#!/usr/bin/env sh

# get script dir
sdir=$(dirname "$0")
cwdir=$(pwd)

# stash cwd if different from script dir
if [ "$sdir" != "$cwdir" ]; then
  cd "$sdir" || exit 1
fi

# invoke installers
. ./install.stack.deb.sh
. ./install.githooks.sh
. ./install.xtratools.deb.sh

# restore cwd if different from script dir
if [ "$sdir" != "$cwdir" ]; then
  cd "$cwdir" || exit 1
fi
