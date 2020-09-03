package com.dxctraining.productmgt.controller;

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

import com.dxctraining.productmgt.dto.CreateRequest;
import com.dxctraining.productmgt.dto.ProductDto;
import com.dxctraining.productmgt.entity.Product;
import com.dxctraining.productmgt.service.ProductService;
import com.dxctraining.productmgt.util.ProductUtil;

@RequestMapping("/products")
@RestController
@Validated
public class ProductController {
	@Autowired
	private ProductService service;
	@Autowired
	private ProductUtil util;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@Valid @RequestBody CreateRequest req) {
		@NotBlank
		String name=req.getName();
		Product prod=new Product(name);
		prod=service.save(prod);
		ProductDto dto=util.productdto(prod);
		return dto;
	}
	@GetMapping("/getid/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto get(@NotNull @PathVariable("id") String id) {
		Product prod=service.findById(id);
		ProductDto dto=util.productdto(prod);
		return dto;
	}
	/*@GetMapping("/getname/{name}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto getByName(@NotBlank @PathVariable("name") String name) {
		Product prod=service.findByName(name);
		ProductDto dto=util.productdto(prod);
		return dto;
	}*/
	@GetMapping("/getname/{name}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto getByName(@NotBlank @PathVariable("name") String name) {
		Product prod=service.findByName(name);
		ProductDto dto=util.productdto(prod);
		return dto;
	}
}
