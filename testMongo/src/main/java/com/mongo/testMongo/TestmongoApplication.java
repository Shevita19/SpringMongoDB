package com.mongo.testMongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class TestmongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestmongoApplication.class, args);
		System.out.println("mongo is running");
	}

	public MongoClient getClient(){
		return new com.mongodb.MongoClient("localhost", 27017);
	}

	@Override
	public void run(String... args) throws Exception {
		com.mongodb.MongoClient mongoClient = getClient();;
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeeCollection = database.getCollection("employee");
		Document employee1 =  new Document();
		employee1.append("firstName", "Shweta");
		employee1.append("lastName", "Soi");
		employee1.append("email", "cde");
		employee1.append("address", "gggg");
		employeeCollection.insertOne(employee1);
	}
}
