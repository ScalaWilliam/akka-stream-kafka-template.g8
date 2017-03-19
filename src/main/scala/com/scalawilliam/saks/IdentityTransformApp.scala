package com.scalawilliam.saks

import akka.Done
import akka.actor.ActorSystem
import akka.kafka.scaladsl.{Consumer, Producer}
import akka.kafka.{ConsumerSettings, ProducerMessage, ProducerSettings, Subscriptions}
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, ByteArraySerializer, StringDeserializer, StringSerializer}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object IdentityTransformApp extends App {

  private val config = ConfigFactory.load()
  private val inputTopic = config.getString("input-topic")
  private val outputTopic = config.getString("output-topic")
  private implicit val actorSystem =
    ActorSystem("identity-transform-system", config)

  try {
    val producerSettings = ProducerSettings(actorSystem,
                                            new ByteArraySerializer,
                                            new StringSerializer)
    val consumerSettings = ConsumerSettings(actorSystem,
                                            new ByteArrayDeserializer,
                                            new StringDeserializer)
    implicit val actorMaterializer = ActorMaterializer()

    val completion: Future[Done] =
      Consumer
        .committableSource(consumerSettings, Subscriptions.topics(inputTopic))
        .map { msg =>
          ProducerMessage.Message(new ProducerRecord(
                                    outputTopic,
                                    null,
                                    msg.record.timestamp,
                                    msg.record.key,
                                    msg.record.value
                                  ),
                                  msg.committableOffset)
        }
        .runWith(Producer.commitableSink(producerSettings))

    Await.result(completion, Duration.Inf)
  } finally {
    Await.result(actorSystem.terminate(), Duration.Inf)
  }

}
