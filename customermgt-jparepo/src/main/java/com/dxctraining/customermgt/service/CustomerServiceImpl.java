package com.dxctraining.customermgt.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.customermgt.dao.CustomerDao;
import com.dxctraining.customermgt.entities.Customer;
import com.dxctraining.customermgt.exception.NotFoundException;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;
	
	@Override
	public Customer save(Customer customer) {
		customer= dao.save(customer);
		return customer;
	}
	@Override
	public Customer findById(Integer id) {
		Optional<Customer> op= dao.findById(id);
		boolean b=op.isPresent();
		if(!b) {
			throw new NotFoundException("not found");
		}
		Customer customer=op.get();
		return customer;
	}
	@Override
	public Customer findByName(String name) {
		Customer customer= dao.findByName(name);
		return customer;
	}	
	

}
