package nelsonssoares.deserializer;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import nelsonssoares.dto.ProductDTO;

public class ProductDeserializer extends ObjectMapperDeserializer<ProductDTO> {
    public ProductDeserializer() {
        super(ProductDTO.class);
    }
}
