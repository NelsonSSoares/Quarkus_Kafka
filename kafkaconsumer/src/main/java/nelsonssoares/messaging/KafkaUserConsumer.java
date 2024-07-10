package nelsonssoares.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import nelsonssoares.constants.MessagingConstants;
import nelsonssoares.dto.UserDTO;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaUserConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaUserConsumer.class);

    @Incoming(MessagingConstants.USERTOPIC)
    @Transactional
    public void receiveUser(UserDTO userDTO) {
        logger.info("Receiving new User: " + userDTO);
    }
}
