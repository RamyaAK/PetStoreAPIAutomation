package petStore.pet.AddNewPetToStore;

import io.restassured.response.Response;
import petStore.pet.AddNewPetToStore.request.AddNewPetRequest;
import petStore.pet.AddNewPetToStore.response.AddNewPetResponse;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class AddNewPetClient {
    public AddNewPetResponse addNewPetToStore(AddNewPetRequest requestBody) {
        API_Properties api_properties = new API_Properties();

        String url = String.format("%s/pet", api_properties.baseURL);
        System.out.println(requestBody.toString());

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        System.out.println(response.toString());
        AddNewPetResponse addNewPetResponse = response.as(AddNewPetResponse.class);
        addNewPetResponse.setHttpStatusCode(response.getStatusCode());
        return addNewPetResponse;
    }
}
