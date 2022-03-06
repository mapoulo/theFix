package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.User;
import com.example.demo.Pojo.DataValue;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	
	@GetMapping("name/{name}")
	public User findUserByName(@PathVariable String name) {
		return service.findUserByName(name);
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		return service.getUserById(id);
	}
	
	
	@DeleteMapping("/")
	public String deleteAllUsers() {
		return service.deleteAllUsers();
	}
	
	

}
