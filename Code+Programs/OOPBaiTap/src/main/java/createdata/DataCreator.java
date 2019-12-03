/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createdata;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;
import entity.AEntity;
import filereader.DataReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import setting.Config;

/**
 *
 * @author Laptop88
 */
public class DataCreator {

    private ArangoDatabase conn;
    private DataStoreder storeder = new DataStoreder(new ArrayList<BaseDocument>());

    private ArrayList<String>[] listEntity;
    private ArrayList<String>[] listDescription;

    private String[] strNameEntity = Config.strNameEntity;
    private HashMap<Integer, int[]> entityCollection = Config.entityCollection;
    private int numberEntity;
    
//    public void setListEntity(ArrayList<String>[] listEntity){

    public DataCreator(ArangoDatabase conn, int numberEntity) {
        this.listEntity = new ArrayList[6];
        this.listDescription = new ArrayList[6];
        this.conn = conn;
        this.numberEntity = numberEntity;
        this.getEntityAndDescription();
    }

    /**
     * Sinh các thực thể có trong tập EntityData Vòng for đầu để duyệt tất cả
     * các thực thể như Person, Event ... Vòng for thứ hai duyệt tất cả dữ liệu
     * đã đọc được của mỗi thực thể đang xét để sinh dữ liệu tương ứng. Mỗi dữ
     * liệu sau khi sinh được đưa vào model. Khi model đủ 250000 triple sẽ đưa
     * lên server
     */
    public void createData() {
        SingleEntityCreator creator = new SingleEntityCreator();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            for (int count = 0; count < entityCollection.get(numberEntity)[i]; count++) {
                String key = strNameEntity[i] + count;
                String name = listEntity[i].get(rand.nextInt(listEntity[i].size()));
                String description = listDescription[i].get(rand.nextInt(listDescription[i].size()));
                AEntity newEntity = creator.createEntity(key, name, description);
                HashMap<Object, Object> properties = newEntity.getListProperties();
                properties = createRelation(properties, strNameEntity[i]);
                storeder.storeEntity(properties);
                if (storeder.getListDocuments().size() > 250000) {
                    storeCollection(strNameEntity[i]);
                }
            }
            storeCollection(strNameEntity[i]);
        }

    }

    
    public HashMap<Object, Object> createRelation( HashMap<Object, Object> properties , String strNameEntity1) {
        Random random = new Random();
        for(int i = 0; i < 3; i++){
            if(Config.Relationships.get(strNameEntity1).length == 0){
                return properties;
            }
            int relationNumber = random.nextInt(Config.Relationships.get(strNameEntity1).length); // Lấy ngẫu nhiên một quan hệ của thực thể
            String strNameEntity2 = Config.Relationships.get(strNameEntity1)[relationNumber][1];  // Lấy tên thực thể thứ 2 trong quan hệ
            String relationName = Config.Relationships.get(strNameEntity1)[relationNumber][0];   // Lấy tên quan hệ để lưu vào cơ sở dũ liệu
            int numberEntity2 = entityCollection.get(numberEntity)[0];
            for(int x = 0; x < 6; x++){
                if(strNameEntity[x] == strNameEntity2){
                    numberEntity2 = entityCollection.get(numberEntity)[x];
                    break;
                }
            }
            if(properties.containsKey(relationName)){ // Nếu trong thực thể đã lưu quan hệ này thì ta thêm entityKey vào mảng chứa quan hệ
                ArrayList<String> arrayKey = (ArrayList<String>) properties.get(relationName);
                arrayKey.add(strNameEntity2 + random.nextInt(numberEntity2));
                properties.put(relationName, arrayKey);
                
            }else{  // Nếu thục thể chưa chứa quan hệ này ta tạo mới mảng chứa entityKey và thêm vào thực thể
                ArrayList<String> arrayKey = new ArrayList<String>();
                arrayKey.add(strNameEntity2 + random.nextInt(numberEntity2));
                properties.put(relationName, arrayKey);
            }
        }
        return properties;
    }
    
    
    public void getEntityAndDescription() {
        filereader.DataReader reader = new filereader.DataReader();
        for (int i = 0; i < 6; i++) {
            String pathEntity = Config.DIR_DATA_PATH + "/Entity/" + strNameEntity[i] + ".txt";
            reader.setPath(pathEntity);
            listEntity[i] = reader.readFile();
//            System.out.print(listEntity[i].size());
//            System.out.print("  ");
            
            String pathDescription = Config.DIR_DATA_PATH + "/Description/" + strNameEntity[i] + ".txt";
            reader.setPath(pathDescription);
            listDescription[i] = reader.readFile();
//            System.out.print(listDescription[i].size());
//            System.out.print("  ");
        }
    }

    private void storeCollection(String collectionName) {
        try {
            conn.createCollection(collectionName);
            conn.collection(collectionName).insertDocuments(storeder.getListDocuments());
            storeder.getListDocuments().clear();
        } catch (final ArangoDBException e) {
            System.err.println("Failed to create document. " + e.getMessage());
        }

    }
}
