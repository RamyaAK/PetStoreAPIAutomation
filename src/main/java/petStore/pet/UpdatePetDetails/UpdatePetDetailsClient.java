package petStore.pet.UpdatePetDetails;

import io.restassured.response.Response;
import petStore.pet.UpdatePetDetails.request.UpdatePetRequest;
import petStore.pet.UpdatePetDetails.response.UpdatePetResponse;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class UpdatePetDetailsClient {
    public UpdatePetResponse updatePetDetails(UpdatePetRequest requestBody){
        String url = String.format("%s/pet", API_Properties.baseURL);
        System.out.println(url);
        System.out.println(requestBody.toString());

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
        UpdatePetResponse updatePetResponse = response.as(UpdatePetResponse.class);
        updatePetResponse.setHttpStatusCode(response.getStatusCode());
        return updatePetResponse;
    }
}
