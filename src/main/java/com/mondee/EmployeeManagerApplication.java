package com.mondee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}

}