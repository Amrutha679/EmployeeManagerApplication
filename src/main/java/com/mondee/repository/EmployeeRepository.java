package com.mondee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mondee.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}