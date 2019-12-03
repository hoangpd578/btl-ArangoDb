package entity;

import java.util.HashMap;

public abstract class AEntity {
    
    private String key = null;
    private String name = null;
    private String description = null;

    // Constructor
    public AEntity(String key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
    }
    
    public AEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public AEntity(String name) {
        this.name = name;
    }

    /**
     * Lưu các thuộc tính của Entity vào list. Các lớp thực thể khác muốn thêm
     * các thuộc tính mới có thể kế thừa phương thức này
     */
    public HashMap<Object, Object> getListProperties() {
        HashMap<Object, Object> properties = new HashMap<Object, Object>();
        properties.put("key", key);
        properties.put("name", name);
        properties.put("description", description);
        return properties;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
