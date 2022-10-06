package builder;

import petStore.pet.UpdatePetDetails.request.UpdatePetRequest;
import utils.RestUtils;

import java.util.List;
import java.util.Map;

public class UpdatedPetBuilder {

    RestUtils restUtils = new RestUtils();

    UpdatePetRequest updatePetRequest;
    List<Map<String, Object>> tags;
    Map<String, Object> categories = new CategoriesBuilder().build();

    public  UpdatedPetBuilder(){
        tags = new TagBuilder().build();
        updatePetRequest = new UpdatePetRequest();
        updatePetRequest.setName(restUtils.getName());
        updatePetRequest.setPhotoUrls(restUtils.getPhotoUrls());
        updatePetRequest.setId(83789+restUtils.getTagId());
        updatePetRequest.setCategory(categories);
        updatePetRequest.setTags(tags);
        updatePetRequest.setStatus("available");

    }
    public UpdatePetRequest build(){
        return updatePetRequest;
    }

}
