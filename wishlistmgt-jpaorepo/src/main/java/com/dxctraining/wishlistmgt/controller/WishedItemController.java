package com.dxctraining.wishlistmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.wishlistmgt.dto.CreateRequest;
import com.dxctraining.wishlistmgt.dto.CustomerDto;
import com.dxctraining.wishlistmgt.dto.ProductDto;
import com.dxctraining.wishlistmgt.dto.WishedItemDto;
import com.dxctraining.wishlistmgt.entity.WishedItem;
import com.dxctraining.wishlistmgt.service.WishedItemService;
import com.dxctraining.wishlistmgt.util.WishedItemUtil;

@RestController
@RequestMapping("/wished")
public class WishedItemController {
	@Autowired
	private WishedItemService service;
	@Autowired
	private WishedItemUtil util;
	@Autowired
	private RestTemplate rest;
	
	@PostMapping("/add")
	public WishedItemDto add(@RequestBody CreateRequest req) {
		int customerid=req.getCustomerid();
		String productid=req.getProductid();
		WishedItem wisheditem=new WishedItem(customerid,productid);
		wisheditem=service.save(wisheditem);
		WishedItemDto dto=util.wisheddto(wisheditem);
		return dto;
	}
	@GetMapping("/get/{id}")
	public WishedItemDto get(@PathVariable("id") int id) {
	WishedItem wisheditem=service.findById(id);
	int customerid=wisheditem.getCustomerid();
	String productid=wisheditem.getProductid();
	CustomerDto cdto=fetchCustomer(customerid);
	ProductDto pdto=fetchProduct(productid);
	WishedItemDto dto=util.wisheditemdto( id,cdto.getId(),cdto.getName(),pdto.getId(),pdto.getName());
	
	return dto;
	}
	public CustomerDto fetchCustomer(Integer customerid) {
		String url="http://localhost:8585/customers/getcustomer/"+customerid;
		CustomerDto cdto=rest.getForObject(url, CustomerDto.class);
		return cdto;
	}
	public ProductDto fetchProduct(String productid) {
		String url="http://localhost:8686/products/getid/"+productid;
		ProductDto pdto=rest.getForObject(url, ProductDto.class);
		return pdto;
	}
	
}
