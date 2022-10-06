package petStore.pet.GetPetByStatus;

import io.restassured.response.Response;
import petStore.pet.GetPetByStatus.response.GetPetByStatusResponse;
import petStore_Entities.Status;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class GetPetByStatusClient {
    public GetPetByStatusResponse[] getPetByStatus(Status status) {
        String url = String.format("%s/pet/findByStatus?status=%s", API_Properties.baseURL, status);
        System.out.println(url);
        Response response = given()
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .log().all().extract().response();

        GetPetByStatusResponse[] getPetByStatusResponse = response.as(GetPetByStatusResponse[].class);
        return getPetByStatusResponse;
    }

}
