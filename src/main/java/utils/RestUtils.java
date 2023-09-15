package utils;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;

public class RestUtils {
    String generatedString = RandomStringUtils.randomAlphabetic(1);
    int generatedInteger = Integer.parseInt(RandomStringUtils.randomNumeric(1));

    private int tagId;
    private String tagName;
    public String name;
    public List<String> photoUrls;

    @Getter
    public int id;
    @Getter
    public String username;
    @Getter
    public String firstName;
    @Getter
    public String lastName;
    @Getter
    public String email;
    @Getter
    public String password;
    @Getter
    public String phone;
    @Getter
    public int userStatus;


    public int getTagId() {
        return 1+generatedInteger;
    }

    public String getTagName() {
        return "tag"+generatedString;
    }

    public String getName() {
        return name+generatedString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return Collections.singletonList(photoUrls + generatedString);
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setId(int id) {
        this.id = id+generatedInteger;
    }

    public void setUsername(String username) {
        this.username = "roy"+generatedString;
    }

    public void setFirstName(String firstName) {
        this.firstName = "Blac"+generatedString;
    }

    public void setLastName(String lastName) {
        this.lastName = "zyoco"+generatedString;
    }

    public void setEmail(String email) {
        this.email = "abc"+generatedString+"@"+"gmail.com";
    }

    public void setPassword(String password) {
        this.password = "abc@123";
    }

    public void setPhone(String phone) {
        this.phone = "998765560"+generatedInteger;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = 123466718;
    }
}
