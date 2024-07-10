# KAFKA 

Este é um exemplo de como implementar produzir e consumir mensagens de filas do Kafka.

Acompanhe o README de cada projeto para executar corretamente.

# KAFKA PRODUCER DEPENDENCIES

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

# KAFKA CONSUMER DEPENDENCIES

```
 <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.32</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-rest-jackson</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-messaging-kafka</artifactId>
        </dependency>
```
