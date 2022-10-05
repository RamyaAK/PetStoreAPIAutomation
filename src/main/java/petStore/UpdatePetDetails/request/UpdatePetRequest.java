package petStore.UpdatePetDetails.request;

import java.util.List;
import java.util.Map;

public class UpdatePetRequest {

    public String name;
    public List<String> photoUrls;
    public int id;
    public Map<String, Object> category;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getCategory() {
        return category;
    }

    public void setCategory(Map<String, Object> category) {
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
        return "UpdatePetRequest{" +
                "name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", id=" + id +
                ", category=" + category +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
