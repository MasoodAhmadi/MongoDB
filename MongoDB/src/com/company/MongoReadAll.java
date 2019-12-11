package com.company;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoReadAll {

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase("testdb");

            MongoCollection<Document> collection = database.getCollection("cars");

            try (MongoCursor<Document> cur = collection.find().iterator()) {

                while (cur.hasNext()) {

                   // var doc = cur.next();
                   // var cars = new ArrayList<>(doc.values());

                  //  System.out.printf("%s: %s%n", cars.get(1), cars.get(2));
                }
            }
        }
    }
}