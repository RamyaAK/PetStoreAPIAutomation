package petStoreAPITests;

import base.BaseTest;
import builder.CreatePetBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.AddNewPetToStore.AddNewPetClient;
import petStore.AddNewPetToStore.request.AddNewPetRequest;
import petStore.AddNewPetToStore.response.AddNewPetResponse;
import petStore.GetPetById.GetPetByIdClient;
import petStore.GetPetById.response.GetPetByIdResponse;
import org.hamcrest.Matchers.*;

import static org.hamcrest.Matchers.equalTo;

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
        int tag1Id = (int) addNewPetRequest.getTags().get(0).get("id");
        int tag2Id = (int) addNewPetRequest.getTags().get(1).get("id");

        String tag1Name = (String) addNewPetRequest.getTags().get(0).get("name");
        String tag2Name = (String) addNewPetRequest.getTags().get(1).get("name");


        Assert.assertEquals(getPetByIdResponse.getId(), petId);
        Assert.assertEquals(getPetByIdResponse.getName(), "Rocky");

        Assert.assertEquals(addNewPetResponse.getTags().get(0).get("id"), tag1Id);
        Assert.assertEquals(addNewPetResponse.getTags().get(1).get("id"), tag2Id);

        Assert.assertEquals(addNewPetResponse.getTags().get(0).get("name"), tag1Name);
        Assert.assertEquals(addNewPetResponse.getTags().get(1).get("name"), tag2Name);

        Assert.assertEquals(addNewPetResponse.getCategory().getId(), 47476709);
        Assert.assertEquals(addNewPetResponse.getCategory().getName(), "laborum ullamco labore magna");

    }

    @AfterTest
    public void closeTest() {
        System.out.println("Test ended successfully!");
    }
}
