package builder;

import utils.RestUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TagBuilder {
    Map<String, Object> tag1 = new HashMap<String, Object>();
    Map<String, Object> tag2 = new HashMap<String, Object>();
    List<Map<String, Object>> tagsList = new LinkedList<Map<String, Object>>();
    RestUtils restUtils = new RestUtils();

    public TagBuilder() {
        System.out.println(restUtils.getTagId());
        System.out.println(restUtils.getTagName());

        tag1.put("id", restUtils.getTagId());
        tag1.put("name", restUtils.getTagName());

        tag2.put("id", restUtils.getTagId()+1);
        tag2.put("name", restUtils.getTagName()+"pet");

        tagsList.add(tag1);
        tagsList.add(tag2);

    }

    public List<Map<String, Object>> build() {
        return tagsList;
    }


}
