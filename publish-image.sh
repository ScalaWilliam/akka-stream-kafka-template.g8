#!/bin/bash
if [ ! -z "$AWS_ACCESS_KEY_ID" ] &&
  [ ! -z "$AWS_SECRET_ACCESS_KEY" ] &&
  [ ! -z "$AWS_ACCOUNT_ID" ] &&
  [ ! -z "$AWS_REGION" ] &&
  [ ! -z "$AWS_DOCKER_REPOSITORY" ];
then
  pip install --user awscli
  export PATH=$PATH:$HOME/.local/bin
  eval $(aws ecr get-login --region $AWS_REGION)
  docker tag play-container "$AWS_ACCOUNT_ID".dkr.ecr."$AWS_REGION".amazonaws.com/"$AWS_DOCKER_REPOSITORY":latest
  docker push "$AWS_ACCOUNT_ID".dkr.ecr."$AWS_REGION".amazonaws.com/"$AWS_DOCKER_REPOSITORY":latest
else
  echo "Not publishing to AWS ECR due to missing requirements."
fi
if [ ! -z "$DOCKER_USERNAME" ] &&
[ ! -z "$DOCKER_PASSWORD" ] &&
[ ! -z "$DOCKER_REPOSITORY" ]; then
  docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD";
  docker tag play-container "$DOCKER_REPOSITORY";
  docker push "$DOCKER_REPOSITORY";
else
  echo "Not publishing Docker Hub due to missing environment variables."
fi
