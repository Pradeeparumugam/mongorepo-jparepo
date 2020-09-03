package com.dxctraining.productmgt.service;

import com.dxctraining.productmgt.entity.Product;

public interface ProductService {
	Product save(Product prod);
	Product findById(String id);
	Product findByName(String name);
}
