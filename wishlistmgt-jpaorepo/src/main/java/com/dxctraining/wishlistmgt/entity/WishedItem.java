package com.dxctraining.wishlistmgt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WishedItem {
	@Id
	@GeneratedValue
	private int id;
	private int customerid;
	private String productid;
	
	public WishedItem(int customerid,String productid) {
		this.customerid = customerid;
		this.productid = productid;
	}
	public WishedItem() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	@Override
	public int hashCode() {
		
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishedItem other = (WishedItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
