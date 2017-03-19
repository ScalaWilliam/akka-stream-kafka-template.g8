# Play + Travis CI + Docker Hub project

> Build a [Play Framework 2.5](https://www.playframework.com/documentation/2.5.x/ScalaHome) project on [Travis CI](https://travis-ci.org/).
<br>When in the `master` [branch](https://help.github.com/articles/github-glossary/#branch) 
publish to [Docker Hub](https://hub.docker.com/).

## Use cases

To create a self contained Play app that you can distribute publicly to users via Docker Hub.

## Configuration options

For Travis CI, after signing up to Docker Hub and creating a 'repository' (project), set these:
* `DOCKERHUB_USERNAME`
* `DOCKERHUB_PASSWORD`

## Usage of final image

```
$ docker run \
    -p 80:9000 \
    -e "JAVA_OPTS=-Dplay.crypto.secret=example-secret" \
    -it \
    scalawilliam/play-docker-example 
```

Then go to http://localhost/

# Choices

## Travis CI
It's industry standard for open source projects. Circle CI didn't work nicely with Play and Codeship is not very standard.

## Play framework
Static typing, scalable in the long term. Read my answer to: [What are the advantages and disadvantages of play framework?
](https://www.quora.com/What-are-the-advantages-and-disadvantages-of-play-framework/answer/William-Narmontas).

## Docker Hub
Easy distribution and comes automatically with Docker. Very easy way to distribute your applications to users,
with many options to run applications on the cloud and locally.

To create a self contained Play app that you can distribute publicly to users via Docker Hub.

## Configuration options

For Travis CI, after signing up to Docker Hub and creating a 'repository' (project), set these:
* `DOCKER_USERNAME`
* `DOCKER_PASSWORD`
* `DOCKER_REPOSITORY`

## Usage of final image

```
$ docker run \
    -p 80:9000 \
    -e "JAVA_OPTS=-Dplay.crypto.secret=example-secret" \
    -it \
    scalawilliam/play-docker-example 
```

Then go to http://localhost/

# Choices

## Travis CI
It's industry standard for open source projects. Circle CI didn't work nicely with Play and Codeship is not very standard.

## Play framework
Static typing, scalable in the long term. Read my answer to: [What are the advantages and disadvantages of play framework?
](https://www.quora.com/What-are-the-advantages-and-disadvantages-of-play-framework/answer/William-Narmontas).

## Docker Hub
Easy distribution and comes automatically with Docker. Very easy way to distribute your applications to users,
with many options to run applications on the cloud and locally.
