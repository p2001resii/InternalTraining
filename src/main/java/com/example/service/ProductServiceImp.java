package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.FetchProductRespose;
import com.example.bean.InsertProductBean;
import com.example.bean.InsertProductReq;
import com.example.bean.UpdateProductBean;
import com.example.dao.ProductDao;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductDao productdao;

	@Override
	public Boolean insertProductByBeanProperty(InsertProductBean insertProductBean) {
		return productdao.insertProductByBeanProperty(insertProductBean);
	}

	@Override
	public Boolean updateProductByBeanProperty(UpdateProductBean updateProductBean) {
		return productdao.updateProductByBeanProperty(updateProductBean);
	}
	//-----------------------------------Insert and Update same API------------------------------
	@Override
	public Boolean insertAndUpdateProductDetails(InsertProductReq insertProductReq) {
		Boolean insertFlag = false;
		Boolean updateFlag = false;
		if (CollectionUtils.isNotEmpty(insertProductReq.getProductList())) {
			List<InsertProductBean> saveProductList = new ArrayList<>();
			List<InsertProductBean> updateProductList = new ArrayList<>();
			for (InsertProductBean insertProductObj : insertProductReq.getProductList()) {
				
				insertProductObj.setOrgId(insertProductReq.getOrgId());
				if (insertProductObj.getProductId() == null) {
					saveProductList.add(insertProductObj);
				} else {
					updateProductList.add(insertProductObj);
				}
			}
			if (CollectionUtils.isNotEmpty(saveProductList)) {
				insertFlag = productdao.insertProductDetails(saveProductList);
			}
			if (CollectionUtils.isNotEmpty(updateProductList)) {
				updateFlag = productdao.updateProductDetails(updateProductList);
			}
		}
		return insertFlag || updateFlag;
	}
	
     //---------------------------------------batch  insert and update-------------------------------------------------//
	@Override
	public Boolean insertProductReq(InsertProductReq insertProductReq) {
		return productdao.insertProductReq(insertProductReq);
	}
	

	@Override
	public Boolean updateProductReq(InsertProductReq insertProductReq) {
		return productdao.updateProductReq(insertProductReq);
	}

	@Override
	public Boolean insertOrgAndProductDetails(InsertProductReq insertProductReq) {
		// TODO Auto-generated method stub
		return null;
	}


		//------------------------------------multiple table--------------------------------------------
		
		//@Override
	//	public Boolean insertOrgAndProductDetails(InsertProductReq insertProductReq) {
//			
//			Boolean insertFlag = false;
//			Boolean updateFlag = false;
//			
//			if (CollectionUtils.isNotEmpty(insertProductReq.getProductList())) {
//				List<InsertProductReq> saveProductList = new ArrayList<>();
//				List<InsertProductReq> updateProductList = new ArrayList<>();
//				for (InsertProductBean insertProductObj : insertProductReq.getProductList()) {
//					insertProductReq.setOrgId(insertProductReq.getOrgId());
//					if (insertProductObj.getProductId() == null) {
//						saveProductList.add(insertProductReq);
//					} else {
//						updateProductList.add(insertProductReq);
//					}
//				}
//				if (CollectionUtils.isNotEmpty(saveProductList)) {
//					insertFlag = productdao.insertOrgAndProductDetails(saveProductList);
//				}
//				if (CollectionUtils.isNotEmpty(updateProductList)) {
//					updateFlag = productdao.updateOrgAndProductDetails(updateProductList);
//				}
//			}
//			return insertFlag || updateFlag;
//			
//		}

		//---------------------------------------------fetch by query for object---------------------------------------------

		@Override
		public InsertProductBean getProductDetails(int productId) {
			return productdao.getProductDetails(productId);
		}
  //------------------------------------------------fetch by using map-----------------------------------------
		@Override
		public FetchProductRespose getProductDetailsByUsingMap(InsertProductBean insertProductBean) {
			
			Map<String, Object> map = productdao.fetchProductDetailsByUsingMap(insertProductBean);
			
			if(map!=null) {   
				FetchProductRespose fetchProductDetails = new FetchProductRespose();
			
				fetchProductDetails.setProductId((Long)map.get("product_Id"));  
				fetchProductDetails.setProductNm((String)map.get("product_Nm"));
				fetchProductDetails.setProductCategory((String)map.get("product_category"));
				fetchProductDetails.setProductPrice((Double)map.get("product_Price"));
			    fetchProductDetails.setProductQty((Integer)map.get("product_Qty"));
			   fetchProductDetails.setManufacturer((String)map.get("manufacturer"));
			   return fetchProductDetails;
			}
			return null;
		}

		@Override
		public Map<String, Object> getProductDetailsByUsingMapDynamic(InsertProductBean insertProductBean) {
			
			return productdao.getProductDetailsByUsingMapDynamic(insertProductBean);
		}


		
		
	//--------------------------------------------fetch by using query----------------------------------------------------

		@Override
		public List<InsertProductBean> fetchProductDetailsByUsingQuery() {
			return productdao.fetchProductDetailsByUsingQuery();
		}
		 //----------fetch by using query dynamically
		@Override
		public List<InsertProductBean> fetchProductDetailsByUsingQuery(InsertProductBean insertProductBean) {
			return productdao.fetchProductDetailsByUsingQuery(insertProductBean);
		}

		
		
		///------------------------------------------fetch by using list--------------------------------------

		
		@Override
		public List<FetchProductRespose> getProductDetailsByUsingList(InsertProductBean insertProductBean) {
			
			List<Map<String, Object>> list = productdao.fetchProductDetailsByUsingList(insertProductBean);
			List<FetchProductRespose> beanResponse = new ArrayList<>();
			if (list != null && !list.isEmpty()) {
				for (Map<String, Object> map : list) {
					FetchProductRespose fetchProductBeanResponse = new FetchProductRespose();
					

					fetchProductBeanResponse.setProductId((Long)map.get("product_Id"));  
					fetchProductBeanResponse.setProductNm((String)map.get("product_Nm"));
					fetchProductBeanResponse.setProductCategory((String)map.get("product_category"));
					fetchProductBeanResponse.setProductPrice((Double)map.get("product_Price"));
					fetchProductBeanResponse.setProductQty((Integer)map.get("product_Qty"));
					fetchProductBeanResponse.setManufacturer((String)map.get("manufacturer"));
					beanResponse.add(fetchProductBeanResponse);
					
				}
				return beanResponse;
			}
			return null;
			

		}

		
		}
      

		

   


		


