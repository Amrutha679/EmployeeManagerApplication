package com.mondee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mondee.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
	
}