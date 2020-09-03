package com.dxctraining.productmgt.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.productmgt.entity.Product;

public interface ProductDao extends MongoRepository<Product,String>{
	Product findByName(String name);
}
