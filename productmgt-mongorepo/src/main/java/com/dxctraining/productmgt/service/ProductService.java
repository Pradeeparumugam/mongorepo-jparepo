package com.dxctraining.productmgt.service;

import java.util.List;

import com.dxctraining.productmgt.entity.Product;

public interface ProductService {
	Product save(Product prod);
	Product findById(String id);
	List<Product> findByName(String name);
}
