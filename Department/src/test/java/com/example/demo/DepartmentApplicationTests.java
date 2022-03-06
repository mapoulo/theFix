package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DepartmentApplicationTests {

	@Test
	void contextLoads() {
		assertThat(true).isEqualTo(true);
	}

	
	@Test
	void theTest() {
		assertThat(true).isEqualTo(true);
	}
}
