package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.bean.FetchProductRespose;
import com.example.bean.InsertProductBean;
import com.example.bean.InsertProductReq;
import com.example.bean.UpdateProductBean;

public interface ProductService {

		Boolean insertProductByBeanProperty(InsertProductBean insertProductBean);

		Boolean updateProductByBeanProperty(UpdateProductBean insertProductBean);
		
		
		Boolean insertAndUpdateProductDetails(InsertProductReq insertProductReq);
		

		Boolean insertProductReq(InsertProductReq insertProductReq);

		Boolean updateProductReq(InsertProductReq insertProductReq);
		

		Boolean insertOrgAndProductDetails(InsertProductReq insertProductReq);
		

		InsertProductBean getProductDetails(int productId);

		FetchProductRespose getProductDetailsByUsingMap(InsertProductBean insertProductBean);

		Map<String, Object> getProductDetailsByUsingMapDynamic(InsertProductBean insertProductBean);

		List<FetchProductRespose> getProductDetailsByUsingList(InsertProductBean insertProductBean);

		List<InsertProductBean> fetchProductDetailsByUsingQuery();

		List<InsertProductBean> fetchProductDetailsByUsingQuery(InsertProductBean insertProductBean);

		


	
	

}