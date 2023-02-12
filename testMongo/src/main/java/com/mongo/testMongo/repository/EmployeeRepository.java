package com.mongo.testMongo.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongo.testMongo.model.Employee;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByFirstNameStartingWith(String firstName);



    List<Employee> findByAddressZipCode(int zipCode);

    @Query(value="{'salary': {$gte:?0}}")
    List<Employee> findBySalaryGreaterThan(float salary);
}
//    @Query(value="{'salary': {$gte:?0}}, fields= "{'firstName':1, 'id':0}")
//    List<Employee> findBySalaryGreaterThan(float salary);
//}


/*
@Repository
public class EmployeeRepository {

    MongoClient client;
    MongoClient getClient() {
        if (client == null) {
        client = new MongoClient("localhost", 27017);
    }
    return client;
    }
    public List<Employee> getAll() {

        MongoClient mongoClient = getClient();
        MongoDatabase database= mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("employee");


        List<Employee> response = new ArrayList<Employee>();

        for(Document e : collection.find()){      //find is returiing obj of iterable and we are going thru each element and conveting those elements into our employy class  and put that employy class into list so m returning this response as response of function.

            Employee emp = new Employee(e.get("_id").toString(), e.getString ("firstName"), e.getString("lastName"),
                    e.getString("address"));
            response.add(emp);
        }

        return response;

    }*/

