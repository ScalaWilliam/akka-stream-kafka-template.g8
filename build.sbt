name := "play-sse-file"
libraryDependencies += "com.lightbend.akka" %% "akka-stream-alpakka-file" % "0.6"
enablePlugins(PlayScala)
scalaVersion := "2.12.1"
dockerBaseImage := "java:openjdk-8-jre"
enablePlugins(DockerPlugin)
dockerExposedPorts += 9000
