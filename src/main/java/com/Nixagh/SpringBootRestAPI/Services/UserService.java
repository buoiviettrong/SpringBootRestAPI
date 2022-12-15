package com.Nixagh.SpringBootRestAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nixagh.SpringBootRestAPI.Repositories.UserRepository;
import com.Nixagh.SpringBootRestAPI.models.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User login(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}
}
