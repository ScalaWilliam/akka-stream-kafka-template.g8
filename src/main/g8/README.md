# $name$

# Building

* Docker image, locally: `sbt docker:publishLocal`
* Docker image: `sbt docker:publish`
* Distribution package (bare): `sbt 'show stage'`
* Distribution package (zip): `sbt 'show stage'` or `sbt 'show dist'`

## Configuration options

* `input-topic`
* `output-topic`
* `akka.kafka.consumer.kafka-clients.group.id`
* `akka.kafka.consumer.kafka-clients.bootstrap.servers`
* `akka.kafka.producer.kafka-clients.bootstrap.servers`

## Running locally

```
\$ ./target/universal/stage/bin/$project_name$ \
    -Dinput-topic=blah -Doutput-topic=bleh ...
```

## Running in Docker

```
\$ export JAVA_OPTS=" \
-Dinput-topic=blah \
-Doutput-topic=blah \
...
"
\$ docker run -e JAVA_OPTS -i $project_name$
```

## Further detail

Built using [akka-stream-kafka-template.g8](https://github.com/ScalaWilliam/akka-stream-kafka-template.g8)
