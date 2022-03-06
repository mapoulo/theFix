package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Entity.User;
import com.example.demo.Repositories.UserRepo;
import com.example.demo.Services.UserService;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	
	@Mock
	private UserRepo repo;
	private UserService serviceUndertest;
	
	
	@BeforeEach
	void beForeEach() {
		serviceUndertest = new UserService(repo);
	}
	
	
	@Test
	void testSaveUser() {
		//Given
		User user = new User(0, "Nkwe", "Mapoulo", 0);
		//When
	    serviceUndertest.saveUser(user);
	    //Then
	    ArgumentCaptor<User>  userArgumentCapture = ArgumentCaptor.forClass(User.class);
	    verify(repo).save(userArgumentCapture.capture());
	    User myUser = userArgumentCapture.getValue();
	    assertThat(myUser.getName()).isEqualTo("Nkwe");
	    
	}
	
	
	@Test
	void testGetAllUsers() {
		//When
		serviceUndertest.getAllUsers();
	    //Then 
		verify(repo).findAll();
	}
	
	
	


}
