package builder;

import petStore.pet.UpdatePetDetails.request.UpdatePetRequest;
import petStore.user.request.CreateUserRequest;
import utils.RestUtils;

public class CreateUserBuilder {
   CreateUserRequest createUserRequest;
    RestUtils restUtils = new RestUtils();
    public  CreateUserBuilder(){
        createUserRequest = new CreateUserRequest();
        createUserRequest.setId(restUtils.getId());
        createUserRequest.setUsername(restUtils.getUsername());
        createUserRequest.setFirstName(restUtils.getFirstName());
        createUserRequest.setLastName(restUtils.getLastName());
        createUserRequest.setEmail(restUtils.getEmail());
        createUserRequest.setPassword(restUtils.getPassword());
        createUserRequest.setPhone(restUtils.getPhone());
        createUserRequest.setUserStatus(restUtils.getUserStatus());


    }
    public CreateUserRequest build(){
        return createUserRequest;
    }

}
