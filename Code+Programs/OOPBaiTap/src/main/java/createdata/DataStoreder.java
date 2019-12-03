/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createdata;

import com.arangodb.entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import setting.Config;

/**
 *
 * @author Laptop88
 */
public class DataStoreder {
    private ArrayList<BaseDocument> listDocuments;
    
    private BaseDocument document;
    
    public DataStoreder(ArrayList<BaseDocument> listDocuments) {
        this.listDocuments = listDocuments;
    }
    
    /**
     * Chuyển đổi các đối tượng thực thể thành các đối tượng BaseDocument và lưu vào một ArrayList.
     *
     * @param properties : List các thuộc tính cần lưu trữ lấy từ dữ liệu thực
     * thể . Phần tử nào trong mảng là null sẽ không được lưu
     */
    public void storeEntity(HashMap<Object, Object> properties) {
        // Tạo thực thể định danh, tạo 2 triple để kết nối chúng 2 chiều
        // Tạo type của thực thể, kết nối thực thể với type
        document = new BaseDocument();
        document.setKey((String) properties.get("key"));
        properties.remove("key");
        properties.forEach((key, value) -> {
            document.addAttribute((String)key, value);
        });
        
        listDocuments.add(document);
    }
    
    public ArrayList<BaseDocument> getListDocuments() {
    	return listDocuments;
    }
}
