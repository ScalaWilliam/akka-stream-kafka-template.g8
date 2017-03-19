name := "play-docker-example"
scalaVersion := "2.11.8"
dockerBaseImage := "java:openjdk-8-jre"
enablePlugins(DockerPlugin)
dockerRepository := Some("scalawilliam")
