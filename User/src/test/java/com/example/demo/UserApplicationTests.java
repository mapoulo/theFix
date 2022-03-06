package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.Entity.User;
import com.example.demo.Repositories.UserRepo;


@DataJpaTest
class UserApplicationTests {
	
	
	@Autowired
	private UserRepo repo;
	
	
	
	@AfterEach
	void deleteAllValues() {
		repo.deleteAll();
	}
	
	
	@Disabled
	@Test
	void getUserByEmail() {
		
		//Given 
		User user = new User(0, "Nkwedd", "Mapoulo", 0);
		
		//When 
		repo.save(user);
		
		
		//Then 
	   User theUser = repo.findUserByName("Nkwe").get();
	   
	   assertThat(theUser.getName()).isEqualTo("Nkwe");
	}
	
	
	@Disabled
	@Test
	void testGetUserBySurname() {
		
		//Given
		User user = new User(0, "John", "Doe", 0);
		//When
		User theUser = repo.save(user);
		//Then
		assertThat(theUser.getName()).isEqualTo("John");
	}
	
	
	
	


}
