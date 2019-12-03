/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setting;

import java.util.HashMap;

/**
 *
 * @author Laptop88
 */
public class Config {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8529;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "phamvanthoai";

    public static final String DIR_PATH = System.getProperty("user.dir");
    public static final String DIR_DATA_PATH = DIR_PATH + "/RawData";
    public static final String DIR_QUERY_PATH = DIR_PATH + "/Query";
    public static final String DEFAULT_LINK = "https://vi.wikipedia.org/wiki/";

    private static final int[] x1 = {5, 5, 5, 5, 5, 75};
    private static final int[] x2 = {50, 50, 50, 50, 50, 4750};    //entityCollection
    private static final int[] x3 = {220, 220, 220, 220, 220, 58900};
    private static final int[] x4 = {220, 220, 220, 220, 220, 98900};
    private static final int[] x5 = {220, 220, 220, 220, 220, 498900};

    public static final String[] strNameEntity = {"Agreement", "Organization", "Location", "Event", "City", "Person"};
    public static final HashMap<Integer, int[]> entityCollection = new HashMap<Integer, int[]>() {
        {
            put(100, x1);
            put(5000, x2);
            put(60000, x3);
            put(100000, x4);
            put(500000, x5);
        }
    };
    
    private static final String[][] PersonRelation = new String[][]{
        {"GapGoPerson", "Person"},
        {"ToChucEvent", "Event"},
        {"ThamGiaEvent", "Event"},
        {"ThamGiaOrganization", "Organization"},
        {"ThamGiaAgreement", "Agreement"},
        {"UngHoCity", "City"},
        {"UngHoAgreement", "Agreement"},
        {"UngHoEvent", "Event"},
        {"PhanDoiCity", "City"},
        {"PhanDoiAgreement", "Agreement"},
        {"PhanDoiEvent", "Event"},
        {"PhatBieuEvent", "Event"},
        {"HuyBoAgreement", "Agreement"},
        {"HuyBoEvent", "Event"},
    };
    private static final String[][] CityRelation = new String[][]{
        {"KyHopDongCity", "City"},
        {"UngHoCity", "City"},
        {"UngHoAgreement", "Agreement"},
        {"UngHoEvent", "Event"},
        {"PhanDoiCity", "City"},
        {"PhanDoiAgreement", "Agreement"},
        {"PhanDoiEvent", "Event"},
        {"CangThangCity", "City"},
        {"HuyBoAgreement", "Agreement"},
        {"HuyBoEvent", "Event"},
        {"DamPhanCity", "City"},
    };
    private static final String[][] OrganizationRelation = new String[][]{
        {"ToChucEvent", "Event"},
        {"ThamGiaEvent", "Event"},
        {"ThamGiaOrganization", "Organization"},
        {"ThamGiaAgreement", "Agreement"},
    };
    private static final String[][] EventRelation = new String[][]{
        {"DienRaTaiCity", "City"},
        {"DienRaTaiLocation", "Location"},
    };
    
    public static final HashMap<String, String[][]> Relationships = new HashMap<String, String[][]>() {
        {
            put("Person", PersonRelation);
            put("City", CityRelation);
            put("Organization", OrganizationRelation);
            put("Event", EventRelation);
            put("Location", new String[][]{});
            put("Agreement", new String[][]{});
            
            
        }
    };

}
