# `akka-stream-kafka-identity`: kafka topic to kafka topic identity transform + Docker

> Using akka-streams, transform one Kafka topic to another.<br>
Serve as a base building block for a Kafka stream converter

## Usage

### Configuration
* App specific configuration
* Akka Kafka Consumer
* Akka Kafka Producer

### Running
* How to stage & run locally
* How to publish and run in Docker

## Usage

```
$ docker run \
    -p 80:9000 \
    -e "JAVA_OPTS=-Dplay.crypto.secret=example-secret" \
    -it \
    scalawilliam/play-docker-example 
```
