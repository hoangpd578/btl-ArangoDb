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
public class Person extends AEntity{

    private int age;
    private String birthday;
    private String sex;

    // Constructor
    public Person(String key, String name, String description) {
        super(key, name, description);
    }
    public Person(String name, String description) {
        super(name, description);
    }
    public Person(String name) {
        super(name);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public HashMap<Object, Object> getListProperties() {
        HashMap<Object, Object> properties = super.getListProperties();
        properties.put("age", age);
        properties.put("birthday", birthday);
        properties.put("sex", sex);
        return properties;
    }
}
