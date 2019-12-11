package com.company;

import com.mongodb.client.*;
import org.bson.Document;
public class MongoProjection {

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("Company");
            MongoCollection<Document> collection = database.getCollection("EMPLOYEE");
            try (MongoCursor<Document> cur = collection.find().iterator()){
                // FindIterable it = collection.find().projection(excludeId());
                // MongoDatabase docs = (MongoDatabase) new ArrayList<Document>();
                //it.into((Collection) docs);
                int record = 0;
                while (cur.hasNext()){
                    Document doc = cur.next();
                    System.out.println(doc);
                }
                //  for (Document doc : docs) {
                System.out.println("found " +record + " records");
                //  System.out.println(doc);
                //  }
            }
        }
    }
}