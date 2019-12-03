/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashMap;

/**
 *
 * @author Laptop88
 */
public class Location extends AEntity{

    private String coordinates;

    public String getToaDo() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    // Constructor
    public Location(String key, String name, String description) {
        super(key, name, description);
    }
    public Location(String name, String description) {
        super(name, description);
    }
    public Location(String name) {
        super(name);
    }

    public HashMap<Object, Object> getListProperties() {
        HashMap<Object, Object> properties = super.getListProperties();
        properties.put("coordinates", coordinates);
        return properties;
    }
}
