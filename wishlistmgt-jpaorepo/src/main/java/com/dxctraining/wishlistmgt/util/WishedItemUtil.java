package com.dxctraining.wishlistmgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.wishlistmgt.dto.WishedItemDto;
import com.dxctraining.wishlistmgt.entity.WishedItem;

@Component
public class WishedItemUtil {
	public WishedItemDto wisheddto(WishedItem wisheditem) {
		WishedItemDto dto=new WishedItemDto(wisheditem.getId(),wisheditem.getCustomerid(),wisheditem.getProductid());
		return dto;
	}
	public WishedItemDto wisheditemdto(int id,int customerid,String customername,String productid,String productname) {
		WishedItemDto dto=new WishedItemDto();
		dto.setId(id);
		dto.setCustomerid(customerid);
		dto.setCustomername(customername);
		dto.setProductid(productid);
		dto.setProductname(productname);
		return dto;
	}
}
