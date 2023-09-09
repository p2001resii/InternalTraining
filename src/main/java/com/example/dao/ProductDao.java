package com.example.dao;

import java.util.List;
import java.util.Map;

import com.example.bean.InsertProductBean;
import com.example.bean.InsertProductReq;
import com.example.bean.UpdateProductBean;

public interface ProductDao {


	Boolean insertProductByBeanProperty(InsertProductBean insertProductBean);

	Boolean updateProductByBeanProperty(UpdateProductBean updateProductBean);

	Boolean insertProductReq(InsertProductReq insertProductReq);

	Boolean updateProductReq(InsertProductReq insertProductReq);

	Boolean insertOrgAndProductDetails(List<InsertProductReq> saveProductList);

	Boolean updateOrgAndProductDetails(List<InsertProductReq> updateProductList);

	InsertProductBean getProductDetails(int productId);

	Map<String, Object> fetchProductDetailsByUsingMap(InsertProductBean insertProductBean);

	List<Map<String, Object>> fetchProductDetailsByUsingList(InsertProductBean insertProductBean);

	Map<String, Object> getProductDetailsByUsingMapDynamic(InsertProductBean insertProductBean);

	List<InsertProductBean> fetchProductDetailsByUsingQuery();

	List<InsertProductBean> fetchProductDetailsByUsingQuery(InsertProductBean insertProductBean);

	Boolean insertProductDetails(List<InsertProductBean> saveProductList);

	Boolean updateProductDetails(List<InsertProductBean> updateProductList);


}