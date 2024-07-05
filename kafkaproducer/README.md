# KAFKA PRODUCERS

## Iniciando o KafkaProducer

Para iniciar este projeto corretamente, execute o container da mensageria Kafka, com os comandos abaixo.

### 1. Iniciando Container Kafka

1.2 Execute o docker-compose.yaml que contem no repositório deste projeto, ou crie um com o código abaixo:
```shell script
docker-compose up
```
```
version: '3'

services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    networks:
      - broker-kafka
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  kafka:
    image: confluentinc/cp-kafka:latest
    networks:
      - broker-kafka
    depends_on:
      - zookeeper
    ports:
      - "9092:9092" #
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:29092,PLAINTEXT_HOST://localhost:9092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  kafdrop:
    image: obsidiandynamics/kafdrop:latest
    networks:
      - broker-kafka
    depends_on:
      - kafka
    ports:
      - "19000:9000"
    environment:
      KAFKA_BROKERCONNECT: kafka:29092

networks:
  broker-kafka:
    driver: bridge
```

1.3 Verifique se o Kafka Iniciou corretamente em: http://localhost:19000/

Documentação Quakus Kafka: https://pt.quarkus.io/guides/kafka


### 2.Iniciando KafkaProducer
```shell script
./mvnw compile quarkus:dev
```
> **_NOTA:_** depois de inicar, as filas serao criadas pode ser vistas kafdrop, neste caso, user e product. http://localhost:19000/

2.1 Utilize o API Client de sua preferência e acesse os endpoints:


Endpoint User JSON: http://localhost:8080/send/user
```
{
    "name":"Elon Musk",
    "age":"52",
    "country":"South Africa"
}
```

Endpoint Product JSON: http://localhost:8080/send/product
```
{
    "name":"BMW Z4",
    "description":"convertible car",
    "quantity":20
}
```

2.2 Veja na fila escolhida sua mensagem publicada em http://localhost:19000/