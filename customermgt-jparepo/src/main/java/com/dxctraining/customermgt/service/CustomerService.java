package com.dxctraining.customermgt.service;

import com.dxctraining.customermgt.entities.Customer;

public interface CustomerService {
	 Customer save(Customer customer);
	 Customer findById(Integer id);
	 Customer findByName(String name);

}
