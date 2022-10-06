package petStoreAPITests.pet;

import base.BaseTest;
import builder.CreatePetBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.pet.AddNewPetToStore.AddNewPetClient;
import petStore.pet.AddNewPetToStore.request.AddNewPetRequest;
import petStore.pet.AddNewPetToStore.response.AddNewPetResponse;
import petStore.pet.DeletePetByID.DeletePetByIDClient;
import petStore.pet.DeletePetByID.DeletePetResponse;
import petStore_Entities.Pet;

public class DeletePetByIDTest extends BaseTest {
    AddNewPetRequest addNewPetRequest;
    AddNewPetResponse addNewPetResponse;
    Pet pet = new Pet();

    @BeforeTest
    public void prepareTestData() {
        System.out.println("creating the Pet Object");
        addNewPetRequest = new CreatePetBuilder().build();

    }

    @Test
    public void deletePetByIdTest() {
        // calling AddNewPetClient with AddNewPetRequest object before delete operation.
        addNewPetResponse = new AddNewPetClient().addNewPetToStore(addNewPetRequest);

        pet.setPetId(addNewPetResponse.getId());
        long pet_id = pet.getPetId();
        System.out.println(pet_id);
        String strPet_ID = Long.toString(pet_id);

        DeletePetResponse deletePetResponse = new DeletePetByIDClient().deletepetByID(pet_id);
        Assert.assertEquals(deletePetResponse.getCode(), 200);
        Assert.assertEquals(deletePetResponse.getMessage(), strPet_ID);
        Assert.assertEquals(deletePetResponse.getType(), "unknown");
    }
}
