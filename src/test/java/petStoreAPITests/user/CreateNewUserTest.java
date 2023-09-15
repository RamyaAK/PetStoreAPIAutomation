package petStoreAPITests.user;

import base.BaseTest;
import builder.CreateUserBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petStore.user.CreateNewUserClient;
import petStore.user.request.CreateUserRequest;
import petStore.user.response.CreateUserResponse;
import petStore_Entities.User;

public class CreateNewUserTest extends BaseTest {
    User user = new User();
    CreateUserRequest createUserRequest;
    CreateUserResponse createUserResponse;

    @BeforeTest
    public void prepareTestData() {
        System.out.println("creating the Pet Object");
        createUserRequest = new CreateUserBuilder().build();

    }

    @Test
    public void CreateNewUserToPetStoreTest() {
        createUserResponse = new CreateNewUserClient().createNewUserForPetStore(createUserRequest);
        Assert.assertEquals(createUserResponse.getCode(), 200);
        Assert.assertEquals(createUserResponse.getType(), "unknown");
        Assert.assertNotNull(createUserResponse.getMessage());

    }


}
