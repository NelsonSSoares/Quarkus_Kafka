package nelsonssoares.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import nelsonssoares.commons.constants.MessagingConstants;
import nelsonssoares.domain.dto.UserDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ApplicationScoped
public class KafkaUserProducer {
    private final Logger logger = LoggerFactory.getLogger(KafkaUserProducer.class);

    @Channel(MessagingConstants.CHANNEL)
    Emitter<UserDTO> sendUser;

    public void sendNewUser(UserDTO userDTO){
        logger.info("Sending message to Kafka" + userDTO);
        sendUser.send(userDTO).whenComplete((success, error)->{
            if(error != null){
                logger.error("An error has occurred!");

            }else {
                logger.info("Message Sent!");
            }
        });
    }
}
