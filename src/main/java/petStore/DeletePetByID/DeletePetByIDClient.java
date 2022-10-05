package petStore.DeletePetByID;

import io.restassured.response.Response;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class DeletePetByIDClient {
    public DeletePetResponse deletepetByID(long petId) {
        String url = String.format("%s/pet/%d", API_Properties.baseURL, petId);
        System.out.println(url);
        Response response = given()
                .contentType("application/json")
                .when()
                .delete(url)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        DeletePetResponse deletePetResponse = response.as(DeletePetResponse.class);
        deletePetResponse.setHttpStatusCode(response.getStatusCode());
        return deletePetResponse;
    }
}
