/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 *
 * @author USER
 */
public class ConnexionMongo {
    public MongoClient getConnection() {
        String connectionString = "mongodb+srv://fenosue:KfVerl6WwTaD2Qyz@cluster0.di0iu4p.mongodb.net/";
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString)).build();
        return MongoClients.create(settings);
    }
}
