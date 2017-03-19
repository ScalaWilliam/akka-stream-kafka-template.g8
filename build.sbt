name := "play-docker-example"
enablePlugins(PlayScala)
scalaVersion := "2.11.8"
dockerBaseImage := "java:openjdk-8-jre"
enablePlugins(DockerPlugin)
dockerExposedPorts += 9000
