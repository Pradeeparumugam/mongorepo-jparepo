package com.dxctraining.wishlistmgt.service;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.wishlistmgt.dao.WishedItemDao;
import com.dxctraining.wishlistmgt.entity.WishedItem;
import com.dxctraining.wishlistmgt.exception.NotFoundException;

@Service
@Transactional
public class WishedItemServiceImpl implements WishedItemService{
	@Autowired
	private WishedItemDao dao;

	@Override
	public WishedItem save(WishedItem wisheditem) {
		 wisheditem=dao.save(wisheditem);
		return wisheditem;
	}
	@Override
	public WishedItem findById(int id) {
		Optional<WishedItem> op=dao.findById(id);
		boolean b=op.isPresent();
		if(!b) {
			throw new NotFoundException("not found");
		}
		WishedItem wisheditem=op.get();
		return wisheditem;
	} 
	
}
