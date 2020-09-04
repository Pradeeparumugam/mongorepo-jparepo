package com.dxctraining.wishlistmgt.dto;

public class WishedItemDto {
	private int id;
	private int customerid;
	private String productid;
	private String customername,productname;
	

	public WishedItemDto(int id,int customerid,String productid) {
		this.id=id;
		this.customerid=customerid;
		this.productid=productid;
	}
	public WishedItemDto() {
		
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
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	
}
