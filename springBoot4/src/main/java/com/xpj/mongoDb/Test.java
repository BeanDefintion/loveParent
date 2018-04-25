package com.xpj.mongoDb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Test {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            MongoCollection<org.bson.Document> mongoCollection = mongoDatabase.getCollection("xpj");
            org.bson.Document document = new Document("title", "monnn").append("ss0", "zzz");
            mongoCollection.insertOne(document);
            System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
