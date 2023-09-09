package com.example.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.FetchProductRespose;
import com.example.bean.InsertProductBean;
import com.example.bean.InsertProductReq;
import com.example.bean.UpdateProductBean;
import com.example.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	//-----------------------------------INSERT and UPDATE --------------------------------------//
	  @PostMapping("/insertProductByBeanProperty")
	    public Boolean insertProductByBeanProperty(@RequestBody InsertProductBean insertProductBean) {
	        return productservice.insertProductByBeanProperty(insertProductBean);
	    }
	
	  @PutMapping("/updateProductByBeanProperty")
	    public Boolean updateProductByBeanProperty(@RequestBody UpdateProductBean insertProductBean) {
	        return productservice.updateProductByBeanProperty(insertProductBean);
	    }
	  //------------------------------------Insert and update single Api----------------------------------------
	  
	  @PostMapping("/insertAndUpdateProduct")
		public Boolean insertAndUpdateProductDetails(@RequestBody InsertProductReq insertProductReq) {
			System.out.println(insertProductReq);
			return productservice.insertAndUpdateProductDetails(insertProductReq);
		}


		//------------------------batch insert and update by jdbctemplate------------------
		
		@PostMapping("/insertProductReqByJdbcTemplate")
		public Boolean insertProductReq(@RequestBody InsertProductReq insertProductReq) {
			
			return  productservice.insertProductReq(insertProductReq);
			 
		}
		
		@PutMapping("/updateProductReqByJdbcTemplate")
		public Boolean updateProductReq(@RequestBody InsertProductReq insertProductReq) {
			
			return  productservice.updateProductReq(insertProductReq);
			 
		}
		//---------------------------- multiple table insertion by using foreign key--------------------------------------------
		
		
			@PostMapping("/insertOrgAndProductDetails")
			public Boolean insertOrgAndProductDetails(@RequestBody InsertProductReq insertProductReq) {
				return productservice.insertOrgAndProductDetails(insertProductReq);
			}
			
			

			//-------------------------fetch by query for object-------------------------------
			
			@PostMapping("/fetchProductDetail/{productId}")
			public InsertProductBean getProductDetails(@PathVariable int productId) {
				
				
				return productservice.getProductDetails(productId);
			}
			
			//---------------------------------fetch by query for map------------------------------
			
			@PostMapping("/fetchproductDetailsByUsingMap")
			public ResponseEntity<FetchProductRespose> getProductDetailsByUsingMap(@RequestBody InsertProductBean insertProductBean) {
				FetchProductRespose productDetailsByUsingMap = productservice.getProductDetailsByUsingMap(insertProductBean);
				return new ResponseEntity<>(productDetailsByUsingMap, HttpStatus.OK);
			}
			@PostMapping("/getProductDetailsByUsingMapDynamic")
			public ResponseEntity<Object> getProductDetailsByUsingMapDynamic(@RequestBody InsertProductBean insertProductBean){
				 Map<String, Object> productDetailsByUsingMapDynamic = productservice.getProductDetailsByUsingMapDynamic(insertProductBean);
				 return new ResponseEntity<Object>(productDetailsByUsingMapDynamic,HttpStatus.OK);
			}
			//-----------------------------------------------fetch the query for list-------------------------------------
			
			@PostMapping("/findByList")
			public List<FetchProductRespose> getProductDetailsByUsingList(@RequestBody InsertProductBean insertProductBean) {
				return productservice.getProductDetailsByUsingList(insertProductBean);
				
			}
			
			
			
		//-----------------------------------------------fetch by query------------------------------------------------
			@PostMapping("/fetchByUsingQuery")
			public List<InsertProductBean> fetchProductDetailsByUsingQuery() {
				return productservice.fetchProductDetailsByUsingQuery();
			}
			@PostMapping("/fetchByUsingQueryDynamically")
			public List<InsertProductBean> fetchProductDetailsByUsingQuery(@RequestBody InsertProductBean insertProductBean) {
				return productservice.fetchProductDetailsByUsingQuery(insertProductBean);
			}
}
      

