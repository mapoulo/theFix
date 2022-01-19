package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Repository.DepartmentRepo;

@Service
public class DepartmentService {
	
	
	
	@Autowired
	private DepartmentRepo repo;
	
	
	public Department save(Department department) {
		return repo.save(department);
	}
	
	
	
	public List<Department>  getAllDepartments(){
		List<Department> departments = new ArrayList<>();
		repo.findAll().forEach(departments::add);
		return departments;
	}
	
	
	public Department getDepartmentById(long id) {
		return repo.findById(id).get();
	}
	
	public String deleteAddDepartments() {
		repo.deleteAll();
		return "All departments deleted";
	}

}
