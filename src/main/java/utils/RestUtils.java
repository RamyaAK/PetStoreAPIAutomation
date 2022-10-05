package utils;
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
}
