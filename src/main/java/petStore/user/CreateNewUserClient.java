package petStore.user;

import io.restassured.response.Response;
import petStore.pet.AddNewPetToStore.request.AddNewPetRequest;
import petStore.pet.AddNewPetToStore.response.AddNewPetResponse;
import petStore.user.request.CreateUserRequest;
import petStore.user.response.CreateUserResponse;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class CreateNewUserClient {
    public CreateUserResponse createNewUserForPetStore(CreateUserRequest requestBody) {
        API_Properties api_properties = new API_Properties();

        String url = String.format("%s/user", api_properties.baseURL);
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
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setHttpStatusCode(response.getStatusCode());
        return createUserResponse;
    }
}