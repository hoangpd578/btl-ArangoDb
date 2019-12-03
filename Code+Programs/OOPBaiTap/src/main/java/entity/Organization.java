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
public class Organization extends AEntity {

    private String foundingDay;

    public String getFoundingDay() {
        return foundingDay;
    }

    public void setFoundingDay(String foundingDay) {
        this.foundingDay = foundingDay;
    }

    // Constructor
    public Organization(String key, String name, String desctiption) {
        super(key, name, desctiption);
    }
    public Organization(String name, String description) {
        super(name, description);
    }
    public Organization(String name) {
        super(name);
    }

    public HashMap<Object, Object> getListProperties() {
        HashMap<Object, Object> properties = super.getListProperties();
        properties.put("founding_day", foundingDay);
        return properties;
    }
}
