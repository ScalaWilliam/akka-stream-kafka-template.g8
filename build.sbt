name := "play-docker-example"
enablePlugins(PlayScala)
scalaVersion := "2.12.1"
dockerBaseImage := "java:openjdk-8-jre"
enablePlugins(DockerPlugin)
dockerExposedPorts += 9000
