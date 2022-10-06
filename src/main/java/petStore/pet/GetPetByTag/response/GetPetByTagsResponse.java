package petStore.pet.GetPetByTag.response;

import petStore.BaseResponse;
import petStore_Entities.Category;

import java.util.List;
import java.util.Map;

public class GetPetByTagsResponse extends BaseResponse {
    public String name;
    public List<String> photoUrls;
    public long id;
    public Category category;
    public List<Map<String, Object>> tags;
    public String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Map<String, Object>> getTags() {
        return tags;
    }

    public void setTags(List<Map<String, Object>> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetPetByTagsResponse{" +
                "name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", id=" + id +
                ", category=" + category +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                ", httpStatusCode=" + httpStatusCode +
                '}';
    }
}
