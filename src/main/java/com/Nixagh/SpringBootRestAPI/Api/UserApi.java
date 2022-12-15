package com.Nixagh.SpringBootRestAPI.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nixagh.SpringBootRestAPI.Services.UserService;
import com.Nixagh.SpringBootRestAPI.models.User;

@RestController
@RequestMapping("/api")
@CrossOrigin /* (origins = "http://127.0.0.1:5500") */
public class UserApi {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAll() {
		return userService.getAll();
	}
}
