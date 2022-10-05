package utils;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    String generatedString = RandomStringUtils.randomAlphabetic(1);
    int generatedInteger = Integer.parseInt(RandomStringUtils.randomNumeric(1));

    private int tagId;
    private String tagName;

    public int getTagId() {
        return 1+generatedInteger;
    }

    public String getTagName() {
        return "tag"+generatedString;
    }
}
