package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Department;
import com.example.demo.Service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService service;
	
	
	
	@PostMapping("/save")
	public Department save(@RequestBody Department department) {
		return service.save(department);
	}
	
	
	@GetMapping("/")
	public List<Department> getAllDepartments(){
		return service.getAllDepartments();
	}
	
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable long id) {
		return service.getDepartmentById(id);
	}
	
	
	@DeleteMapping("/")
	public String deleteAllDepartments() {
		return service.deleteAddDepartments();
	}

}
