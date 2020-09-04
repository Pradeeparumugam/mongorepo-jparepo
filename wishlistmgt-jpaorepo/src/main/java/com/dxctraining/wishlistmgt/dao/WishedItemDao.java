package com.dxctraining.wishlistmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.wishlistmgt.entity.WishedItem;

public interface WishedItemDao extends JpaRepository<WishedItem,Integer>{
	
}
