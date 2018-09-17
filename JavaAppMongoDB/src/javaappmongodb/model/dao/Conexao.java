package javaappmongodb.model.dao;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.*;

public class Conexao {

    private static MongoClient mongo = null;
    private static DB db = null;

    public void alternativaConexao() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("dados_ifrn");
        //MongoCollection<org.bson.Document> collection = database.getCollection("notas");
    }

    public Conexao(String ip, String banco, String porta) {
        try {
            if (this.mongo == null) {
                this.mongo = new MongoClient(
                        new MongoClientURI(
                                "mongodb://" + ip + ":" + porta
                        ));
            }
            if (this.db == null) {
                this.db = mongo.getDB(banco);
            }
        } catch (Exception e) {
        }
    }

    protected MongoClient getMongo() {
        return mongo;
    }

    protected DB getDb() {
        return db;
    }

}
