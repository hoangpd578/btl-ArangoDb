/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Laptop88
 */
public class Event extends AEntity {
    public Event(String key, String name, String description){
        super(key, name, description);
    }
    public Event(String name, String description) {
        super(name, description);
    }
    public Event(String name) {
        super(name);
    }
}
