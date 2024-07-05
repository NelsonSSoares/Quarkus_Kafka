package nelsonssoares.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import nelsonssoares.domain.dto.ProductDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static nelsonssoares.commons.constants.MessagingConstants.PRODUCTCHANNEL;

@ApplicationScoped
public class KafkaProductProducer {
    private final Logger logger = LoggerFactory.getLogger(KafkaUserProducer.class);

    @Channel(PRODUCTCHANNEL)
    Emitter<ProductDTO> sendProduct;

    public void sendNewProduct(ProductDTO productDTO){
        logger.info("Sending message to Kafka" + productDTO);
        sendProduct.send(productDTO).whenComplete((success, error)->{
            if(error != null){
                logger.error("An error has occurred!");
            }else {
                logger.info("Message Sent!");
            }
        });
    }
}
