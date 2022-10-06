package petStore.order;

import io.restassured.response.Response;
import petStore.order.request.PlacePetOrderRequest;
import petStore.order.response.PlacePetOrderResponse;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class PlaceOrderForPetClient {
   public PlacePetOrderResponse placePetOrder(PlacePetOrderRequest requestBody){
       String url = String.format("%s/store/order",API_Properties.baseURL);
       Response response = given()
               .contentType("application/json")
               .body(requestBody)
               .when()
               .post(url)
               .then()
               .extract().response();

       PlacePetOrderResponse placePetOrderResponse =  response.as(PlacePetOrderResponse.class);
               placePetOrderResponse.setHttpStatusCode(response.getStatusCode());
       return placePetOrderResponse;

    }
}
