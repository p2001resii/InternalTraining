package com.example.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class UpdateProductBean {
	
	private Long productId;
	private String productNm;
	private String productCategory;
	private String description;
	private String distributerNm;
	private String manufacturer;
    private String originCountry;
	private Double productPrice;
	private Integer	productQty;
	private String brandName;
	private Date expiryDate;
	private String weightUnit;
	private Boolean isactive;
	private Integer versionId;
	private Timestamp createdDttm;
	private Timestamp modifiedDttm;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDistributerNm() {
		return distributerNm;
	}
	public void setDistributerNm(String distributerNm) {
		this.distributerNm = distributerNm;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public Timestamp getCreatedDttm() {
		return createdDttm;
	}
	public void setCreatedDttm(Timestamp createdDttm) {
		this.createdDttm = createdDttm;
	}
	public Timestamp getModifiedDttm() {
		return modifiedDttm;
	}
	public void setModifiedDttm(Timestamp modifiedDttm) {
		this.modifiedDttm = modifiedDttm;
	}
	
	

}
