package petStoreAPITests.pet;

import base.BaseTest;
import builder.CreatePetBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.pet.AddNewPetToStore.AddNewPetClient;
import petStore.pet.AddNewPetToStore.request.AddNewPetRequest;
import petStore.pet.AddNewPetToStore.response.AddNewPetResponse;
import petStore_Entities.Pet;

public class AddNewPetToStoreTest extends BaseTest {
    Pet pet = new Pet();
    AddNewPetRequest addNewPetRequest;
    AddNewPetResponse addNewPetResponse;

    @BeforeTest
    public void prepareTestData() {
        System.out.println("creating the Pet Object");
        addNewPetRequest = new CreatePetBuilder().build();

    }

    @Test
    public void AddNewPetToStoreTest() {

        // calling AddNewPetClient with AddNewPetRequest object and saving the result in addNewPetResponse for assertion.
        addNewPetResponse = new AddNewPetClient().addNewPetToStore(addNewPetRequest);

        int tag1Id = (int) addNewPetRequest.getTags().get(0).get("id");
        int tag2Id = (int) addNewPetRequest.getTags().get(1).get("id");

        String tag1Name = (String) addNewPetRequest.getTags().get(0).get("name");
        String tag2Name = (String) addNewPetRequest.getTags().get(1).get("name");


        Assert.assertEquals(addNewPetResponse.getName(), "Rocky");
        Assert.assertEquals(addNewPetResponse.getPhotoUrls().get(0), "in occaecat");

        Assert.assertEquals(addNewPetResponse.getTags().get(0).get("id"), tag1Id);
        Assert.assertEquals(addNewPetResponse.getTags().get(1).get("id"), tag2Id);

        Assert.assertEquals(addNewPetResponse.getTags().get(0).get("name"), tag1Name);
        Assert.assertEquals(addNewPetResponse.getTags().get(1).get("name"), tag2Name);

        Assert.assertEquals(addNewPetResponse.getCategory().getId(), 47476709);
        Assert.assertEquals(addNewPetResponse.getCategory().getName(), "laborum ullamco labore magna");

        Assert.assertNotNull(addNewPetResponse.getId());
        System.out.println(addNewPetResponse.getId());

        //saving the response petId for future usage.
        pet.setPetId(addNewPetResponse.getId());
        System.out.println(pet.getPetId());

    }

    @AfterTest
    public void closeTest() {
        System.out.println("Test ended successfully!");
    }

}
