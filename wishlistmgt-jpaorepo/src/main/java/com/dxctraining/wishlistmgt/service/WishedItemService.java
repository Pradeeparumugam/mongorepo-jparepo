package com.dxctraining.wishlistmgt.service;

import com.dxctraining.wishlistmgt.entity.WishedItem;

public interface WishedItemService {
	WishedItem save(WishedItem wisheditem);
	WishedItem findById(int id);
}
