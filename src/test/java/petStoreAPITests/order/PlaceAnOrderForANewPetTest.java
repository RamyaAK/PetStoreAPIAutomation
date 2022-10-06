package petStoreAPITests.order;

import base.BaseTest;
import builder.OrderBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import petStore.order.PlaceOrderForPetClient;
import petStore.order.request.PlacePetOrderRequest;
import petStore.order.response.PlacePetOrderResponse;

public class PlaceAnOrderForANewPetTest extends BaseTest {
    @Test
    public void placeAnOrderForNewPetTest(){
        PlacePetOrderRequest placePetOrderRequest = new OrderBuilder().build();

        int petId = placePetOrderRequest.getPetId();
        int quantity = placePetOrderRequest.getQuantity();
        String shipDate = placePetOrderRequest.getShipDate();
        String status = placePetOrderRequest.getStatus();

        PlacePetOrderResponse placePetOrderResponse = new PlaceOrderForPetClient().placePetOrder(placePetOrderRequest);
        long id = placePetOrderResponse.getId();
        Assert.assertEquals(placePetOrderResponse.getId(),id);
        Assert.assertEquals(placePetOrderResponse.getPetId(),petId);
        Assert.assertEquals(placePetOrderResponse.getQuantity(),quantity);
        Assert.assertEquals(placePetOrderResponse.getShipDate(),shipDate);
        Assert.assertEquals(placePetOrderResponse.getStatus(),status);
        Assert.assertTrue(placePetOrderResponse.isComplete());
    }
}
