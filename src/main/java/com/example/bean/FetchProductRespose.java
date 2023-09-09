package com.example.bean;

public class FetchProductRespose {
	
	private Long productId;
	private String productNm;
	private String productCategory;
	private Double productPrice;
	private Integer	productQty;
	private String manufacturer;
	
	public FetchProductRespose()
	{
		
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductQty() {
		return productQty;
	}
	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public FetchProductRespose(Long productId, String productNm, String productCategory, Double productPrice,
			Integer productQty, String manufacturer) {
		super();
		this.productId = productId;
		this.productNm = productNm;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.manufacturer = manufacturer;
	}

	
}