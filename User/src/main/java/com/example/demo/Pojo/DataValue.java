package com.example.demo.Pojo;

import com.example.demo.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataValue {
	
	
	private User user;
	private Department department;

}
