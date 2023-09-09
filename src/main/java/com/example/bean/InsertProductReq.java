package com.example.bean;

import java.util.List;


public class InsertProductReq {
	
	private Integer orgId;
	private List<InsertProductBean> productList;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public List<InsertProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<InsertProductBean> productList) {
		this.productList = productList;
	}
	
	
}


