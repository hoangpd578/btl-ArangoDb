/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import setting.Config;


/**
 *
 * @author Laptop88
 */
public class ServerConnection {

    private final String host, user, password;
    private final int port;
    private final ArangoDB arangoDB;
    private ArangoDatabase db;
    private static ServerConnection serverConnection;
    

    private ServerConnection(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.arangoDB = new ArangoDB.Builder()
                .host(host, port)
                .user(user)
                .password(password)
                .build();
    }

    private ServerConnection() {
        this.host = Config.HOST;
        this.port = Config.PORT;
        this.user = Config.USERNAME;
        this.password = Config.PASSWORD;
        this.arangoDB = new ArangoDB.Builder()
                .host(Config.HOST, Config.PORT)
                .user(Config.USERNAME)
                .password(Config.PASSWORD)
                .build();
    }

    
    public static ServerConnection getServerConnecter(String host, int port, String user, String password) {
        if (serverConnection == null) {
            serverConnection = new ServerConnection(host, port, user, password);
        }
        if (!host.equals(serverConnection.host) || !user.equals(serverConnection.user)
                || !password.equals(serverConnection.password)) {
            serverConnection.arangoDB.shutdown();
            serverConnection = new ServerConnection(host, port, user, password);
        }
        return serverConnection;
    }
    
    public ArangoDB getServerDB() {
        return arangoDB;
    }
    
    public ArangoDatabase getDatatabase(String databaseName) {
        if (arangoDB.getDatabases().contains(databaseName)) {
            db = arangoDB.db(databaseName);
        }else{
            arangoDB.createDatabase(databaseName);
            db = arangoDB.db(databaseName);
        }
        return db;
    }
    
    public ArangoDatabase getNewDatatabase(String databaseName) {
        if (arangoDB.getDatabases().contains(databaseName)) {
            arangoDB.db(databaseName).drop();
        }
        arangoDB.createDatabase(databaseName);
        db = arangoDB.db(databaseName);
        return db;
    }
    
    public void closeConnection() {
        if (arangoDB == null) {
            return;
        }
        arangoDB.shutdown();
    }
}
