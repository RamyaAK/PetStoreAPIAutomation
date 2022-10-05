package petStore_Entities;

public class Tag {
    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String abc) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "TagsItem{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
