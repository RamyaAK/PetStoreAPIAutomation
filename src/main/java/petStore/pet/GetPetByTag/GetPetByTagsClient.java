package petStore.pet.GetPetByTag;

import io.restassured.response.Response;
import petStore.pet.GetPetByTag.response.GetPetByTagsResponse;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class GetPetByTagsClient {

    public GetPetByTagsResponse[] getPetByTagsResponses(String tagName1, String tagName2){
        String url = String.format("%s/pet/findByTags?tags=%s&tags=%s", API_Properties.baseURL,tagName1,tagName2);
        System.out.println(url);

        Response response = given()
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response();

        GetPetByTagsResponse[] getPetByTagsResponses =response.as(GetPetByTagsResponse[].class);
        return getPetByTagsResponses;
    }
}
