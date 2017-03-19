name := "scala-akka-kafka-stream"
scalaVersion := "2.12.1"

libraryDependencies += "com.typesafe.akka" %% "akka-stream-kafka" % "0.14"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
dockerBaseImage := "java:openjdk-8-jre"
dockerRepository := Some("scalawilliam")
