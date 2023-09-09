package com.example.bean;

import java.util.List;

public class UpdateProductReq {
	private Integer orgId;
	private List<UpdateProductBean> productList;
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public List<UpdateProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<UpdateProductBean> productList) {
		this.productList = productList;
	}

}
