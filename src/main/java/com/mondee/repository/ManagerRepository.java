package com.mondee.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mondee.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

}
