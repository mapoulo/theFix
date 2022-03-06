package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findUserByName(String name);
	
	Optional<User> findUserBySurname(String surname);

}
