package com.dxctraining.customermgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.customermgt.entities.Customer;


public interface CustomerDao extends JpaRepository<Customer,Integer>{
	
	Customer findByName(String name);

}
