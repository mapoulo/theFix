package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.User;
import com.example.demo.Exceptions.ApiRequestException;
import com.example.demo.Pojo.DataValue;
import com.example.demo.Pojo.Department;
import com.example.demo.Repositories.UserRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	
	@Autowired
	private  UserRepo repo;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	
	public User findUserByName(String name) {
		return repo.findUserByName(name).get();
	}
	
//	@CircuitBreaker(name="service1", fallbackMethod = "failedToGetDepartments")
	public List<User>  getAllUsers(){
		List<User> users = new ArrayList<>();
	repo.findAll().forEach(users::add);
		return users;
	}
	
	
	public List<DataValue> failedToGetDepartments(Exception e) {
		List<DataValue> data = new ArrayList<>();
		return data;
	}
	
//	@CircuitBreaker(name="service1", fallbackMethod = "sayFallBack")
//	public String sayHello() {
//		Department d = restTemplate.getForEntity("http://localhost:8091/api/department/4", Department.class).getBody();
//	 return "Say Hello is called";
//	}
	
	public String sayFallBack(Exception e) {
		return "The say Hello fallback";
	}
	
	
	public String deleteAllUsers() {
		repo.deleteAll();
		return "Users deleted";
	}
	
	public User getUserById(long id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}else {
			throw new ApiRequestException("The user with id "+id+" is not found");
		}
	}

}
