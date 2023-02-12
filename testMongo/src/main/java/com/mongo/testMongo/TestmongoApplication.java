package com.mongo.testMongo;

import com.mongo.testMongo.model.Address;
import com.mongo.testMongo.model.Employee;
import com.mongo.testMongo.repository.EmployeeRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestmongoApplication implements CommandLineRunner {

	@Autowired

	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(TestmongoApplication.class, args);
		System.out.println("mongo is running");
	}

	/* public MongoClient getClient(){
		return new com.mongodb.MongoClient("localhost", 27017);
	}

	@Override
	public void run(String... args) throws Exception {
		com.mongodb.MongoClient mongoClient = getClient();

		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> employeeCollection = database.getCollection("employee");
		/*Document employee1 =  new Document();
		employee1.append("firstName", "Shweta");
		employee1.append("lastName", "Soi");
		employee1.append("email", "cde");
		employee1.append("address", "gggg");
		employeeCollection.insertOne(employee1);

		 */


	@Override
	public void run(String... args) throws Exception {


		List<Employee> listOfEmployees = new ArrayList<Employee>();
		Employee e1 = new Employee("EM1", "CD1", new Address("abc", "def", "Gurgaon", "NCR", 1234), 4000);

		Employee e2 = new Employee("EM2", "CD2", new Address("ghi", "jkl", "Delhi", "NCR", 444), 8000);

		Employee e3 = new Employee("EM3", "CD3", new Address("mno", "pqr", "Dwarka", "NCR", 333), 13000);

		Employee e4 = new Employee("EM4", "CD4", new Address("stu", "vwx", "Noida", "NCR", 222), 5000);

		Employee e5 = new Employee("EM5", "CD5", new Address("yza", "bcd", "New Delhi", "NCR", 785), 9000);

		Employee e6 = new Employee("EM6", "CD6", new Address("efs", "ghj", "Faridabad", "NCR", 387), 8000);


		listOfEmployees.add(e1);
		listOfEmployees.add(e2);
		listOfEmployees.add(e3);
		listOfEmployees.add(e4);
		listOfEmployees.add(e5);
		listOfEmployees.add(e6);


		employeeRepository.insert(listOfEmployees);
	}
}
