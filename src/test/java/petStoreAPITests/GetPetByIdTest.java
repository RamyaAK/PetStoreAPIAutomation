package petStoreAPITests;

import base.BaseTest;
import builder.CreatePetBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.AddNewPetToStore.AddNewPetClient;
import petStore.AddNewPetToStore.request.AddNewPetRequest;
import petStore.AddNewPetToStore.response.AddNewPetResponse;
import petStore.GetPetById.GetPetByIdClient;
import petStore.GetPetById.request.GetPetByIdResponse;

public class GetPetByIdTest extends BaseTest {
    AddNewPetRequest addNewPetRequest;
    AddNewPetResponse addNewPetResponse;
    long petId;

    @BeforeTest
    public void prepareTestData() {
        System.out.println("creating the Pet Object");
        addNewPetRequest = new CreatePetBuilder().build();
        addNewPetResponse = new AddNewPetClient().addNewPetToStore(addNewPetRequest);
        petId = addNewPetResponse.getId();

    }

    @Test
    public void GetPetByIDTest() {

        GetPetByIdResponse getPetByIdResponse = new GetPetByIdClient().getPetByIdResponse(petId);

        Assert.assertEquals(getPetByIdResponse.getId(), petId);
        Assert.assertEquals(getPetByIdResponse.getName(), "Rocky");

        Assert.assertEquals(addNewPetResponse.getTags().get(0).get("id"), 1412);
        Assert.assertEquals(addNewPetResponse.getTags().get(1).get("id"), 3476);

        Assert.assertEquals(addNewPetResponse.getTags().get(0).get("name"), "tag1");
        Assert.assertEquals(addNewPetResponse.getTags().get(1).get("name"), "tag2");

        Assert.assertEquals(addNewPetResponse.getCategory().getId(), 47476709);
        Assert.assertEquals(addNewPetResponse.getCategory().getName(), "laborum ullamco labore magna");

    }
}
