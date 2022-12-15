package com.Nixagh.SpringBootRestAPI.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Nixagh.SpringBootRestAPI.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	@Query("{tendn: ?0, pass: ?1}")
	User findByUsernameAndPassword(String username, String password); 
}
