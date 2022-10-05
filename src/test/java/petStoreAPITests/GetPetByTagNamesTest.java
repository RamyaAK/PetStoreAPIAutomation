package petStoreAPITests;

import base.BaseTest;
import builder.CreatePetBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.AddNewPetToStore.AddNewPetClient;
import petStore.AddNewPetToStore.request.AddNewPetRequest;
import petStore.AddNewPetToStore.response.AddNewPetResponse;
import petStore.GetPetByTag.GetPetByTagsClient;
import petStore.GetPetByTag.response.GetPetByTagsResponse;

public class GetPetByTagNamesTest extends BaseTest {
    AddNewPetRequest addNewPetRequest1;
    AddNewPetRequest addNewPetRequest2;

    String tagName1, tagName2;

    @BeforeTest
    public void createAndAddPetWithTagsToStore() {
        System.out.println("creating the Pet Objects");
        addNewPetRequest1 = new CreatePetBuilder().build();
        addNewPetRequest2 = new CreatePetBuilder().build();
        AddNewPetResponse addNewPetResponse1 = new AddNewPetClient().addNewPetToStore(addNewPetRequest1);
        AddNewPetResponse addNewPetResponse2 = new AddNewPetClient().addNewPetToStore(addNewPetRequest2);

        tagName1 = (String) addNewPetRequest1.getTags().get(0).get("name");
        tagName2 = (String) addNewPetRequest2.getTags().get(1).get("name");

        System.out.println(tagName1 + " and " + tagName2);
    }

    @Test
    public void GetPetByTagsTest() {

        GetPetByTagsResponse[] responses = new GetPetByTagsClient().getPetByTagsResponses(tagName1, tagName2);
        System.out.println(responses.length);
        Assert.assertNotNull(responses);
        Assert.assertEquals(responses[0].getTags().get(0).get("name"),tagName1);
    }
}
