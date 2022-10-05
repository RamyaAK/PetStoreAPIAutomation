package petStoreAPITests;

import base.BaseTest;
import builder.CreatePetBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.AddNewPetToStore.request.AddNewPetRequest;
import petStore.GetPetByStatus.GetPetByStatusClient;
import petStore.GetPetByStatus.response.GetPetByStatusResponse;
import petStore_Entities.Status;

public class GetPetByStatusTest extends BaseTest {
    AddNewPetRequest addNewPetRequest;
    @BeforeTest
    public void prepareTestData() {
        System.out.println("creating the Pet Object");
        addNewPetRequest = new CreatePetBuilder().build();

    }
    @Test
    public void GetPetByStatusAsAvailableTest(){

        GetPetByStatusResponse[] responses = new GetPetByStatusClient().getPetByStatus(Status.available);
        System.out.println("Number of pets with Status as available is "+responses.length);
        Assert.assertNotNull(responses);
        Assert.assertEquals(responses[100].getStatus(),"available");
    }
    @Test
    public void GetPetByStatusAsPendingTest(){

        GetPetByStatusResponse[] responses = new GetPetByStatusClient().getPetByStatus(Status.pending);
        System.out.println("Number of pets with Status as available is "+responses.length);
        Assert.assertNotNull(responses);
        Assert.assertEquals(responses[10].getStatus(),"pending");
    }
    @Test
    public void GetPetByStatusAsSoldTest(){

        GetPetByStatusResponse[] responses = new GetPetByStatusClient().getPetByStatus(Status.sold);
        System.out.println("Number of pets with Status as available is "+responses.length);
        Assert.assertNotNull(responses);
        Assert.assertEquals(responses[10].getStatus(),"sold");
    }

    @AfterTest
    public void closeTest() {
        System.out.println("Test ended successfully!");
    }
}
