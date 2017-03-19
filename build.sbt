name := "akka-stream-kafka-mirror"
scalaVersion := "2.12.1"

libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.14"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.2" % Runtime

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
dockerBaseImage := "java:openjdk-8-jre"
dockerRepository := Some("scalawilliam")
