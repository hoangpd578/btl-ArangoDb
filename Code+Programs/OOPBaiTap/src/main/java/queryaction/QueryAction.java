/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryaction;

import java.util.ArrayList;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.ArangoCursor;
import com.arangodb.entity.BaseDocument;
import com.arangodb.model.AqlQueryOptions;
import com.arangodb.util.MapBuilder;
import filereader.QueryReader;
import java.io.IOException;
import java.util.HashMap;
import setting.Config;
import setting.Query;

/**
 *
 * @author Laptop88
 */
public class QueryAction {
    public QueryAction() {

    }

    public ArangoCursor<BaseDocument> getResult(String query, ArangoDatabase db) {
        ArangoCursor<BaseDocument> cursor = db.query( query, new MapBuilder().get(), new AqlQueryOptions(), BaseDocument.class );
        return cursor;
    }

    /**
     * @param result
     * @return kết quả của câu truy vấn
     */
    public void printRows(ArangoCursor<BaseDocument> cursor) throws IOException {

        while (cursor.hasNext()) {
            HashMap<String, Object> doc = (HashMap<String, Object>) cursor.next().getProperties();
            doc.forEach((key, value) -> {
                System.out.print(key + " : " + (String)value);
            });
        }
        cursor.close();
    }


    public ArrayList<Query> getListAdvancedQuery() {
        String pathAdvancedQuery = Config.DIR_QUERY_PATH + "/AdvancedQuery.txt";
        QueryReader reader = new QueryReader(pathAdvancedQuery);
        ArrayList<Query> listAdvancedQuery = reader.readFile();
        return listAdvancedQuery;
    }

    public ArrayList<Query> getListNormalQuery() {
        String pathNormalQuery = Config.DIR_QUERY_PATH + "/NormalQuery.txt";
        QueryReader reader = new QueryReader(pathNormalQuery);
        ArrayList<Query> listNormalQuery = reader.readFile();
        return listNormalQuery;
    }

    /**
     * Tính thời gian chạy câu truy vấn thứ i đồng thời in kết quả ra màn hình
     *
     * @param number Số thứ tự câu truy ấn cần tính
     */
    public String calTime(String Query, ArangoDatabase db) {
        String str = "";

        long startTime = System.currentTimeMillis();
        ArangoCursor<BaseDocument> result = getResult(Query, db);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;

        str += "\n\n------------------------------------" + "\nTotal execution time = "
                + runTime + "ms" + "\n";
        return (str);
    }
}
