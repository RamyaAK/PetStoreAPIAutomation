package petStoreAPITests;

import base.BaseTest;
import builder.CreatePetBuilder;
import builder.UpdatedPetBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.AddNewPetToStore.request.AddNewPetRequest;
import petStore.AddNewPetToStore.response.AddNewPetResponse;
import petStore.UpdatePetDetails.UpdatePetDetailsClient;
import petStore.UpdatePetDetails.request.UpdatePetRequest;
import petStore.UpdatePetDetails.response.UpdatePetResponse;
import petStore_Entities.Pet;

public class UpdatePetDetailsTest extends BaseTest {
    Pet pet = new Pet();
    UpdatePetRequest updatePetRequest;
    UpdatePetResponse updatePetResponse;

    @BeforeTest
    public void prepareTestData() {
        System.out.println("creating the Pet Object");
        updatePetRequest= new UpdatedPetBuilder().build();
    }

    @Test
    public void UpdatePetDetailsTest(){
       updatePetResponse = new UpdatePetDetailsClient().updatePetDetails(updatePetRequest);
        int tag1Id = (int) updatePetRequest.getTags().get(0).get("id");
        int tag2Id = (int) updatePetRequest.getTags().get(1).get("id");

        String tag1Name = (String) updatePetRequest.getTags().get(0).get("name");
        String tag2Name = (String) updatePetRequest.getTags().get(1).get("name");

        Assert.assertEquals(updatePetResponse.getTags().get(0).get("id"), tag1Id);
        Assert.assertEquals(updatePetResponse.getTags().get(1).get("id"), tag2Id);

        Assert.assertEquals(updatePetResponse.getTags().get(0).get("name"), tag1Name);
        Assert.assertEquals(updatePetResponse.getTags().get(1).get("name"), tag2Name);

        Assert.assertEquals(updatePetResponse.getCategory().getId(), 47476709);
        Assert.assertEquals(updatePetResponse.getCategory().getName(), "laborum ullamco labore magna");

        Assert.assertNotNull(updatePetResponse.getId());
        System.out.println(updatePetResponse.getId());

    }
}
