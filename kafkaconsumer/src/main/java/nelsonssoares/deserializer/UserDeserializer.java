package nelsonssoares.deserializer;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import nelsonssoares.dto.UserDTO;

public class UserDeserializer extends ObjectMapperDeserializer<UserDTO> {
    public UserDeserializer() {
        super(UserDTO.class);
    }
}
