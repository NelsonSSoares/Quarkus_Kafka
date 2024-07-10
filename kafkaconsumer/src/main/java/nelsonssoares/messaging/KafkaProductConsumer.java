package nelsonssoares.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import nelsonssoares.dto.ProductDTO;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static nelsonssoares.constants.MessagingConstants.PRODUCTTOPIC;

@ApplicationScoped
public class KafkaProductConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaProductConsumer.class);

    @Incoming(PRODUCTTOPIC)
    @Transactional
    public void receiveProduct(ProductDTO productDTO){
        logger.info("Receiving new Product: "+ productDTO);
    }
}
