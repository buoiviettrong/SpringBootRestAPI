package com.Nixagh.SpringBootRestAPI.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nixagh.SpringBootRestAPI.DTO.loginDTO;
import com.Nixagh.SpringBootRestAPI.Services.UserService;
import com.Nixagh.SpringBootRestAPI.models.User;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class Authentication {
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public User login(@RequestBody loginDTO login) {
		return userService.login(login.getUsername(), login.getPassword());
	}
}
