package com.dxctraining.productmgt.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxctraining.productmgt.entity.Product;

public interface ProductDao extends MongoRepository<Product,String>{
	List<Product> findByName(String name);
}
