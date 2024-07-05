package nelsonssoares.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import nelsonssoares.commons.constants.ControllerConstants;
import nelsonssoares.domain.dto.ProductDTO;
import nelsonssoares.domain.dto.UserDTO;
import nelsonssoares.messaging.KafkaProductProducer;
import nelsonssoares.messaging.KafkaUserProducer;

@Path(ControllerConstants.BASEURL)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageController {

    @Inject
    KafkaUserProducer userProducer;

    @Inject
    KafkaProductProducer productProducer;

    @POST
    @Path(ControllerConstants.USER)
    public void sendUserMessage(UserDTO user){
        userProducer.sendNewUser(user);
    }

    @POST
    @Path(ControllerConstants.PRODUCT)
    public void sendProductMessage(ProductDTO productDTO){
        productProducer.sendNewProduct(productDTO);
    }


}
