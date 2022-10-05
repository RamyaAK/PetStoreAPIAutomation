package builder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TagBuilder {
    Map<String, Object> tag1 = new HashMap<String, Object>();
    Map<String, Object> tag2 = new HashMap<String, Object>();
    List<Map<String, Object>> tagsList = new LinkedList<Map<String, Object>>();

    public TagBuilder() {

        tag1.put("id", 1412);
        tag1.put("name", "tag1");

        tag2.put("id", 3476);
        tag2.put("name", "tag2");

        tagsList.add(tag1);
        tagsList.add(tag2);


    }

    public List<Map<String, Object>> build() {
        return tagsList;
    }

}
