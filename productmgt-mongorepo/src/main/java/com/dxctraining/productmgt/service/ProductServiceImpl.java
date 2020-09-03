package com.dxctraining.productmgt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.productmgt.dao.ProductDao;
import com.dxctraining.productmgt.entity.Product;
import com.dxctraining.productmgt.exception.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao dao;
	
	@Override
	public Product save(Product prod) {
		prod=dao.save(prod);
		return prod;
	}
	@Override
	public Product findById(String id) {
		Optional<Product> op=dao.findById(id);
		boolean b=op.isPresent();
		if(!b) {
			throw new NotFoundException("not found");
		}
		Product prod=op.get();
		return prod;
	}
	@Override
	public Product findByName(String name) {
		Product prod=dao.findByName(name);
		return prod;
	}
}
