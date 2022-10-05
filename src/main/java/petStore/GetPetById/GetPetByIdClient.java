package petStore.GetPetById;

import io.restassured.response.Response;
import petStore.GetPetById.response.GetPetByIdResponse;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class GetPetByIdClient {

    public GetPetByIdResponse getPetByIdResponse(long petId) {

        String url = String.format("%s/pet/%d", API_Properties.baseURL, petId);
        System.out.println(url);

        Response response = given()
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract().response();

        GetPetByIdResponse getPetByIdResponse = response.as(GetPetByIdResponse.class);
        getPetByIdResponse.setHttpStatusCode(response.getStatusCode());
        return getPetByIdResponse;

    }
}
