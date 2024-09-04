#!/usr/bin/env sh

# docker
curl -fsSL https://get.docker.com | sudo sh -s
sudo usermod -aG docker "$USER"
echo "LOGOUT AND LOG BACK IN TO ACTIVATE GROUP CHANGE AND RUN DOCKER IN ROOTLESS MODE"

# helm
