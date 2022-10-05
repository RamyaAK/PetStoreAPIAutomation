package builder;



import java.util.HashMap;
import java.util.Map;

public class CategoriesBuilder {
    Map<String,Object> category = new HashMap<String,Object>();


    public CategoriesBuilder() {

        category.put("id",47476709);
        category.put("name","laborum ullamco labore magna");

    }
    public Map<String, Object> build(){
        return category;
    }
}
