package com.dxctraining.customermgt.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.customermgt.dto.CreateRequest;
import com.dxctraining.customermgt.dto.CustomerDto;
import com.dxctraining.customermgt.entities.Customer;
import com.dxctraining.customermgt.service.CustomerService;
import com.dxctraining.customermgt.util.CustomerUtil;

@RequestMapping("/customers")
@RestController
@Validated
public class CustomerController {
	@Autowired
	private CustomerService service;
	@Autowired
	private CustomerUtil util;

	@PostMapping("/addcustomer")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto create(@Valid@RequestBody CreateRequest req) {
		@NotBlank
		String name = req.getName();
		Customer c = new Customer(name);
		c = service.save(c);
		CustomerDto dto = util.customerdto(c);
		return dto;
	}
	@GetMapping("/getcustomer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDto getCustomerById(@PathVariable("id") Integer id) {
		@NotNull
		Customer c=service.findById(id);
		CustomerDto dto = util.customerdto(c);
		return dto;
	}
	
	@GetMapping("/getname/{name}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerDto getCustomerByName(@PathVariable("name") String name) {
		@NotBlank
		Customer c=service.findByName(name);
		CustomerDto dto = util.customerdto(c);
		return dto;
	}

}
