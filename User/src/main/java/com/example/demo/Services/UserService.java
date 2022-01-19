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

@Service
public class UserService {
	
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private RestTemplate restTemplate;
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	@CircuitBreaker(name="service1", fallbackMethod = "failedToGetDepartments")
	public List<DataValue>  getAllUsers(){
		List<DataValue> users = new ArrayList<>();
		DataValue dataValue = new DataValue();
		repo.findAll().forEach(r->{
			dataValue.setUser(r);
			dataValue.setDepartment(restTemplate.getForEntity("http://localhost:8091/api/department/"+r.getDepartmentId(), Department.class).getBody());
			users.add(dataValue);
		});
		return users;
	}
	
	
	public List<DataValue> failedToGetDepartments(Exception e) {
		List<DataValue> data = new ArrayList<>();
		return data;
	}
	
	@CircuitBreaker(name="service1", fallbackMethod = "sayFallBack")
	public String sayHello() {
		Department d = restTemplate.getForEntity("http://localhost:8091/api/department/4", Department.class).getBody();
	 return "Say Hello is called";
	}
	
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
