package builder;

import petStore.AddNewPetToStore.request.AddNewPetRequest;
import petStore_Entities.Category;
import petStore_Entities.Tag;

import java.util.*;

public class CreatePetBuilder {
    AddNewPetRequest newPetRequest;
    List<Map<String, Object>> tags;

    public CreatePetBuilder() {
        newPetRequest = new AddNewPetRequest();
        Map<String,Object> categories = new CategoriesBuilder().build();
        tags = new TagBuilder().build();

        newPetRequest.setName("Rocky");
        newPetRequest.setPhotoUrls(Arrays.asList("in occaecat", "mollit ullamco et dolore nisi"));
        newPetRequest.setCategory(categories);
        newPetRequest.setTags(tags);
        newPetRequest.setStatus("pending");
    }

    public AddNewPetRequest build() {
        return newPetRequest;
    }

}
