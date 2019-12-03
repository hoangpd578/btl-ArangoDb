/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createdata;

import entity.City;
import entity.AEntity;
import entity.Event;
import entity.Location;
import entity.Organization;
import entity.Person;
import entity.Agreement;
import setting.RandomProperties;

/**
 *
 * @author Laptop88
 */
public class SingleEntityCreator {

    private String key;
    private String name;
    private String description;
    private final RandomProperties rand = new RandomProperties();

    public AEntity createEntity(String key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
        return (createEntity());
    }

    public AEntity createEntity() {
        AEntity ent;
        if (key.startsWith("Person")) {
            ent = createPerson();
        } else if (key.startsWith("City")) {
            ent = createCity();
        } else if (key.startsWith("Location")) {
            ent = createLocation();
        } else if (key.startsWith("Organization")) {
            ent = createOrganization();
        } else if (key.startsWith("Agreement")) {
            ent = createAgreement();
        } else {
            ent = createEvent();
        }
        return ent;
    }

    /**
     * Tạo ngẫu nhiên ngày tháng và link nhận dữ liệu của thực thể
     *
     * @param p: 1 thưc thể bất kỳ
     */
//    private AEntity create(AEntity p) {
//        p.setNgayThang(rand.getRandomDate());
//        p.setLink(rand.getRandomLink(p.getDinhDanh()));
//        return p;
//    }

    /**
     * @param p : Thực thể Person sau khi được tạo ngẫu nhiên
     */
    private Person createPerson() {
        Person p = new Person(key, name, description);
        p.setBirthday(rand.getRandomDate());
        p.setAge(rand.getRandomNumber(100));
        p.setSex(rand.getRandomGioiTinh());
        return p;
    }

    /**
     * @return p : Thực thể Organization sau khi được tạo ngẫu nhiên
     */
    private Organization createOrganization() {
        Organization p = new Organization(key, name, description);
        p.setFoundingDay(rand.getRandomDate());
        return p;
    }

    /**
     * @return p : Thực thể Location sau khi được tạo ngẫu nhiên
     */
    private Location createLocation() {
        Location p = new Location(key, name, description);
        p.setCoordinates(rand.getRandomToaDo());
        return p;
    }

    /**
     * @return p : Thực thể Country sau khi được tạo ngẫu nhiên
     */
    private City createCity() {
        City p = new City(key, name, description);
        p.setPopulation(rand.getRandomNumber(9000000));
        p.setGdp(rand.getRandomNumber(50000));
        p.setArea(rand.getRandomNumber(1000000));
        return p;
    }

    /**
     * @return p : Thực thể Event sau khi được tạo ngẫu nhiên
     */
    private Event createEvent() {
        Event p = new Event(key, name, description);
        return p;
    }

    /**
     * @return p : Thực thể Time sau khi được tạo ngẫu nhiên
     */
    private Agreement createAgreement() {
        Agreement p = new Agreement(key, name, description);
        return p;
    }
}
