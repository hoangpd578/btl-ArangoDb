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
public class City extends AEntity {

    private int population, gdp, area;

    // Constructor
    public City(String key, String name, String description) {
        super(key, name, description);
    }
    public City(String name, String description) {
        super(name, description);
    }
    public City(String name) {
        super(name);
    }
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public HashMap<Object, Object> getListProperties() {
        HashMap<Object, Object> properties = super.getListProperties();
        properties.put("population", population);
        properties.put("GDP", gdp);
        properties.put("area", area);
        return properties;
    }
}
