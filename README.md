***Batteries included!*** 

> Using akka-streams, mirror one Kafka topic to another.<br>
Serve as a base building block for any Kafka Stream applications using Scala

# Relevant documentation

* [Typesafe Config](https://github.com/typesafehub/config)
* [Akka](http://doc.akka.io/docs/akka/2.4/general/index.html)
* [akka-streams](http://doc.akka.io/docs/akka/2.4/scala/stream/index.html)
* [akka-stream-kafka Producer](http://doc.akka.io/docs/akka-stream-kafka/current/producer.html)
* [akka-stream-kafka Consumer](http://doc.akka.io/docs/akka-stream-kafka/current/consumer.html)
* [sbt-native-packager](http://www.scala-sbt.org/sbt-native-packager/)
* [sbt-native-packager Docker Plugin](http://www.scala-sbt.org/sbt-native-packager/formats/docker.html)
* [Essential SBT](https://www.scalawilliam.com/essential-sbt/)
* [Docker Hub](https://docs.docker.com/docker-hub/)
* [What is Docker?](https://www.docker.com/what-docker)
* [logback](https://logback.qos.ch/)

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
