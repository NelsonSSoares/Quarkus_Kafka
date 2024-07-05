# KAFKA 
Este é um exemplo de como implementar produzir e consumir mensagens de filas com Kafka.

Acompanhe o README de cada projeto para executar corretamente.

# KAFKA PRODUCER DEPENDECIES
```
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-rest-jackson</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-messaging-kafka</artifactId>
         </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.32</version>
            <scope>provided</scope>
        </dependency>
```
## Kafka producer properties config
```
quarkus.kafka.devservices.enabled=false

mp.messaging.outgoing.user-channel.connector=smallrye-kafka
mp.messaging.outgoing.user-channel.topic=user
mp.messaging.outgoing.product-channel.topic=product
mp.messaging.connector.smallrye-kafka.bootstrap.servers=localhost:9092

mp.messaging.outgoing.user-channel.value.serializer=io.quarkus.kafka.client.serialization.ObjectMapperSerializer
mp.messaging.outgoing.product-channel.value.serializer=io.quarkus.kafka.client.serialization.ObjectMapperSerializer


```

# KAFKA SUBSCRIBER DEPENDECIES
