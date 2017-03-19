***Batteries included!*** 

> Using akka-streams, mirror one Kafka topic to another.<br>
Serve as a base building block for any Kafka Stream applications using Scala

# Usage

## Local

Assume Kafka running locally.

```
$ sbt 'show stage'
$ ./target/universal/stage/bin/akka-stream-kafka-mirror \
    -Dplay.crypto.secret=example-secret \
    -Dakka.kafka.consumer.kafka-clients.group.id=consumer-group-id \
    -Dakka.kafka.consumer.kafka-clients.bootstrap.servers=localhost:9092 \
    -Dinput-topic=in \
    -Dakka.kafka.producer.kafka-clients.bootstrap.servers=localhost:9092 \
    -Doutput-topic=out
```

## Docker

```
$ export "JAVA_OPTS=-Dplay.crypto.secret=example-secret \
    -Dakka.kafka.consumer.kafka-clients.group.id=consumer-group-id \
    -Dakka.kafka.consumer.kafka-clients.bootstrap.servers=kafka:9092 \
    -Dinput-topic=in \
    -Dakka.kafka.producer.kafka-clients.bootstrap.servers=kafka:9092 \
    -Doutput-topic=out"
```

### Build image locally & run the app

```
$ sbt "set dockerUpdateLatest := true" docker:publishLocal
$ docker run -e JAVA_OPTS -it akka-stream-kafka-mirror
```

### Run image using [public build](https://hub.docker.com/r/scalawilliam/akka-stream-kafka-mirror/) on Docker Hub

```
$ docker run -e JAVA_OPTS -it scalawilliam/akka-stream-kafka-mirror 
```

### Publish to Docker Hub

```
$ docker login
$ sbt docker:publish
```

# Relevant documentation

* Configuration options are parsed by [Typesafe Config](https://github.com/typesafehub/config), the defacto configuration library for Scala.
* [akka-stream-kafka Consumer](http://doc.akka.io/docs/akka-stream-kafka/current/consumer.html) wraps the
  [Kafka Consumer](https://www.confluent.io/blog/tutorial-getting-started-with-the-new-apache-kafka-0-9-consumer-client/)
  in a much more usable way.
* The record goes through [akka-streams](http://doc.akka.io/docs/akka/2.4/scala/stream/index.html) with an offset of the input record. Akka streams
provides very powerful streaming abstractions that can be used with [many connectors, including MQTT, AMQP, SQS](http://developer.lightbend.com/docs/alpakka/current/).
* Once the [akka-stream-kafka Producer](http://doc.akka.io/docs/akka-stream-kafka/current/producer.html) pushes the message the consumer offset is committed automatically. This enables resiliency.
* [SBT](http://www.scala-sbt.org/) compiles our source code. Read [Essential SBT](https://www.scalawilliam.com/essential-sbt/) to get more familiar with SBT.
* [sbt-native-packager](http://www.scala-sbt.org/sbt-native-packager/) packages the Scala application into a deployable unit with its dependencies.
* The [sbt-native-packager Docker Plugin](http://www.scala-sbt.org/sbt-native-packager/formats/docker.html) will go the extra mile to build your Docker image and publish it where you ask it to.
* By default Docker ([What is Docker?](https://www.docker.com/what-docker)) will publish to the [Docker Hub](https://docs.docker.com/docker-hub/) which you should sign up to.
* And finally, for logging, we use [logback](https://logback.qos.ch/).
