package com.mudzingwa.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mudzingwa.sec.model.User;
import com.mudzingwa.sec.service.UserInterf;

@Controller
public class UserController {
	@Autowired
	private UserInterf service;
	@PostMapping("/addUser")
	 public User saveUser(@RequestBody User user) {
		 return service.addUser(user);
	 }
	 
	@GetMapping("/home")
	public String showhome() {
		return "Home";
	
	}
	@GetMapping("/admin")
	public String AdminPage() {
		return "AdminPage";
	}
	
	@GetMapping("/employ")
	public String Employee() {
		return "Employee";
	}
	
	@GetMapping("/student")
	public String StudentPage() {
		return "StudentPage";
	}
	@GetMapping("/welcome")
	public String Welcom() {
		return "WelcomePage";
	}
	@GetMapping("/denied")
	public String PageDenied() {
		return "DeniedPage";
	}


}
