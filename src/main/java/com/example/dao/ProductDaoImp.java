package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.example.bean.FetchProductRespose;
import com.example.bean.InsertProductBean;
import com.example.bean.InsertProductReq;
import com.example.bean.UpdateProductBean;

@Repository
public class ProductDaoImp implements ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;

	boolean count = false;

	@Value("${queries.insertProduct}")
	private String insertquery;

	@Value("${queries.updateProduct}")
	private String updatequery;

//    @Value("${queries.deleteEmployee}")
//    private String deletequery;

	@Override
	public Boolean insertProductByBeanProperty(InsertProductBean insertProductBean) {

		boolean result = false;
		try {
			result = namedParameterJdbcTemplate.update(insertquery,
					new BeanPropertySqlParameterSource(insertProductBean)) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean updateProductByBeanProperty(UpdateProductBean updateProductBean) {
		boolean result = false;
		try {
			result = namedParameterJdbcTemplate.update(updatequery,
					new BeanPropertySqlParameterSource(updateProductBean)) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// ---------------------------------Insert and update same api-------------------------------------

	@Override
	public Boolean insertProductDetails(List<InsertProductBean> saveProductList) {
		String queryForInsertProductDetails = "INSERT INTO Products_info(Org_Id,product_nm,product_category,description,distributer_nm,manufacturer,origin_country,product_price,product_qty,brand_name,expiry_date,weight_unit) VALUES (:orgId,:productNm, :productCategory, :description, :distributerNm, :manufacturer, :originCountry,:productPrice,:productQty,:brandName,:expiryDate,:weightUnit)";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(saveProductList);
		return namedParameterJdbcTemplate.batchUpdate(queryForInsertProductDetails, batch).length > 0;

	}

	@Override
	public Boolean updateProductDetails(List<InsertProductBean> updateProductList) {
		String queryForUpdateProductDetails = "UPDATE Products_info SET org_id=:orgId,product_nm=:productNm, product_category=:productCategory, description=:description, distributer_nm=:distributerNm, manufacturer=:manufacturer, origin_country=:originCountry,product_price=:productPrice,product_qty=:productQty,brand_name=:brandName,expiry_date=:expiryDate,weight_unit=:weightUnit,version_id=version_id+1, modified_dttm=now() WHERE product_id=:productId";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(updateProductList);
		return namedParameterJdbcTemplate.batchUpdate(queryForUpdateProductDetails, batch).length > 0;
	}

	// ------------------------------------------Batch Insert andUpdate-----------------------------------------

	@Override
	public Boolean insertProductReq(InsertProductReq insertProductReq) {
		String query = "insert into products_Info (Org_Id,product_nm,product_category,description,distributer_nm,manufacturer,origin_country,product_price,product_qty,brand_name,expiry_date,weight_unit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		int count[] = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				InsertProductBean insertproductbean = insertProductReq.getProductList().get(i);

				ps.setLong(1, insertProductReq.getOrgId());
				if (insertproductbean.getProductNm() != null) {
					ps.setString(2, insertproductbean.getProductNm());
				} else {
					ps.setNull(2, java.sql.Types.VARCHAR);
				}
				ps.setString(3, insertproductbean.getProductCategory());
				ps.setString(4, insertproductbean.getDescription());
				ps.setString(5, insertproductbean.getDistributerNm());
				ps.setString(6, insertproductbean.getManufacturer());
				ps.setString(7, insertproductbean.getOriginCountry());
				ps.setDouble(8, insertproductbean.getProductPrice());
				ps.setInt(9, insertproductbean.getProductQty());
				ps.setString(10, insertproductbean.getBrandName());
				ps.setDate(11, insertproductbean.getExpiryDate());
				ps.setString(12, insertproductbean.getWeightUnit());

			}

			@Override
			public int getBatchSize() {

				return insertProductReq.getProductList().size();
			}
		});

		return count.length == insertProductReq.getProductList().size();

	}

	@Override
	public Boolean updateProductReq(InsertProductReq insertProductReq) {
		String queryForUpdateProduct = "UPDATE products_Info SET  Org_Id=?, product_nm=?,product_category=?,description=?,distributer_nm=?,manufacturer=?,origin_country=?,product_price=?,product_qty=?,brand_name=?,expiry_date=?,weight_unit=?,version_id=version_id+1,modified_dttm=now() WHERE product_id=?";

		int count[] = jdbcTemplate.batchUpdate(queryForUpdateProduct, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				InsertProductBean insertproductbean = insertProductReq.getProductList().get(i);

				ps.setLong(1, insertProductReq.getOrgId());
				if (insertproductbean.getProductNm() != null) {
					ps.setString(2, insertproductbean.getProductNm());
				} else {
					ps.setNull(2, java.sql.Types.VARCHAR);
				}
				ps.setString(3, insertproductbean.getProductCategory());
				ps.setString(4, insertproductbean.getDescription());
				ps.setString(5, insertproductbean.getDistributerNm());
				ps.setString(6, insertproductbean.getManufacturer());
				ps.setString(7, insertproductbean.getOriginCountry());
				ps.setDouble(8, insertproductbean.getProductPrice());
				ps.setInt(9, insertproductbean.getProductQty());
				ps.setString(10, insertproductbean.getBrandName());
				ps.setDate(11, insertproductbean.getExpiryDate());
				ps.setString(12, insertproductbean.getWeightUnit());
				ps.setLong(13, insertproductbean.getProductId());

			}

			@Override
			public int getBatchSize() {

				return insertProductReq.getProductList().size();
			}
		});

		return count.length == insertProductReq.getProductList().size();

	}

	@Override
	public Boolean insertOrgAndProductDetails(List<InsertProductReq> saveProductList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateOrgAndProductDetails(List<InsertProductReq> updateProductList) {
		// TODO Auto-generated method stub
		return null;
	}

	// ---------------------------------multiple table insert -----------------------------------

//		@Override
//		public Boolean insertOrgAndProductDetails(List<InsertProductReq> saveProductList) {
//			
//			for (InsertProductReq insertProductBean : saveProductList) {
//
//				KeyHolder keyHolder = new GeneratedKeyHolder();
//				
//				jdbcTemplate.update(connection -> {
//					PreparedStatement ps = connection.prepareStatement(
//							"insert into Organisation_tbl(Org_Id) values(?)", new String[] { "Org_Id" });
//					ps.setInt(1, insertProductBean.getOrgId());
//					return ps;
//
//				}, keyHolder);
//				
//				Number key = keyHolder.getKey();
//				
//				List<InsertProductBean> insertProductBeans = insertProductBean.getProductList();
//				jdbcTemplate.batchUpdate(
//						"insert into Product_Fetch_Info(product_nm,product_category,description,distributer_nm,origin_country,department,product_price,product_qty,brand_name,expiry_date,weight_unit,Org_Id,) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
//						new BatchPreparedStatementSetter() {
//							@Override
//							public void setValues(PreparedStatement ps, int i) throws SQLException {
//								ps.setString(2, insertProductBean.getProductNm());
//								ps.setString(3, insertProductBean.getProductCategory());
//								ps.setString(4, insertProductBean.getDescription());
//								ps.setString(5, insertProductBean.getDistributerNm());
//								ps.setString(6, insertProductBean.getManufacturer());
//								ps.setString(7, insertProductBean.getOriginCountry());
//								ps.setDouble(8,insertProductBean.getProductPrice());
//								ps.setInt(9,insertProductBean.getProductQty());
//								ps.setString(10, insertProductBean.getBrandName());
//								ps.setDate(11, insertProductBean.getExpiryDate());
//								ps.setString(12,insertProductBean.getWeightUnit() );
//								ps.setInt(13, key.intValue());
//							}
//
//							@Override
//							public int getBatchSize() {
//								return insertProductBeans.size();
//							}
//						});
//			}
//			
//			return null;
//		
//		}
//	
//	@Override
//	public Boolean updateOrgAndProductDetails(List<InsertProductReq> updateProductList) {
//		return null;
//	}

	// -----------------------------------------fetch by query for object------------------------------------------

	@Override
	public InsertProductBean getProductDetails(int productId) {

		// System.out.println(productId);

		String queryForFetchProductDetails = "select Org_Id,product_id,product_nm,product_category,description,distributer_nm,origin_country,manufacturer,product_price,product_qty,brand_name,expiry_date,weight_unit from products_Info where product_id=:productId";

		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);

		return namedParameterJdbcTemplate.queryForObject(queryForFetchProductDetails, map,
				BeanPropertyRowMapper.newInstance(InsertProductBean.class));

	}
	// -------------------------------------------fetch by map--------------------------------------------

	@Override
	public Map<String, Object> fetchProductDetailsByUsingMap(InsertProductBean insertProductBean) {
		String query2 = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info where  Product_Id=:productId";

		Map<String, Object> map = namedParameterJdbcTemplate.queryForMap(query2,
				new BeanPropertySqlParameterSource(insertProductBean));

		return map;
	}
//-----------------------------------------fetch by map dynamic-------------------------------------

	@Override
	public Map<String, Object> getProductDetailsByUsingMapDynamic(InsertProductBean insertProductBean) {

		String query3 = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info where  Product_Id=:productId";

		StringBuilder query = new StringBuilder(query3);

		if (insertProductBean.getProductId() != null) {
			query.append("and Product_Id=:productId");
		}
		if (insertProductBean.getProductNm() != null) {
			query.append("and Product_Nm=:productName");
		}
		if (insertProductBean.getProductCategory() != null) {
			query.append("and Product_Category=:productCategory");
		}
		if (insertProductBean.getProductNm() != null) {
			query.append("and product_Price=:productPrice");
		}
		if (insertProductBean.getProductNm() != null) {
			query.append("and product_Qty=:productQty");
		}
		if (insertProductBean.getProductNm() != null) {
			query.append("and manufacturer=:manufacturer");
		}

		Map<String, Object> queryForMap = namedParameterJdbcTemplate.queryForMap(query3,
				new BeanPropertySqlParameterSource(insertProductBean));
		return queryForMap;

	}
	// -------------------------------------------------------------fetch the
	// query------------------------------------------------

	@Override
	public List<InsertProductBean> fetchProductDetailsByUsingQuery(InsertProductBean insertProductBean) {
		String queryForFetchData = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info where  1=1";

		StringBuilder query = new StringBuilder(queryForFetchData);

		if (insertProductBean.getProductNm() != null) {

			query.append("AND LOWER(product_nm) LIKE '%' ||LOWER(:productNm)|| '%' ");
		}

		if (insertProductBean.getProductCategory() != null) {
			query.append(" AND LOWER(product_category) LIKE '%' ||LOWER(:ProductCategory) || '%' ");
		}
		if (insertProductBean.getProductPrice() != null) {
			query.append(" AND product_Price=:productPrice");
		}
		if (insertProductBean.getProductQty() != null) {
			query.append(" AND product_Qty=:productQty");
		}
		if (insertProductBean.getManufacturer() != null) {
			query.append(" AND manufacturer=:manufacturer");
		}

		String dynamicQuery = query.toString();
		List<InsertProductBean> list = namedParameterJdbcTemplate.query(dynamicQuery,
				new BeanPropertySqlParameterSource(insertProductBean),
				new BeanPropertyRowMapper(FetchProductRespose.class));

		return list;
	}

	@Override
	public List<InsertProductBean> fetchProductDetailsByUsingQuery() {
		String queryForFetchData = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info";
		List<InsertProductBean> query = namedParameterJdbcTemplate.query(queryForFetchData,
				new BeanPropertyRowMapper(InsertProductBean.class));
		return query;
	}
	// -----------------------------------------------query for list-----------------------------------------

	@Override
	public List<Map<String, Object>> fetchProductDetailsByUsingList(InsertProductBean insertProductBean) {
//		String queryForFetchDatadynamic = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info where  1=1";
		String queryForFetchDatadynamic = "select * from products_Info where 1=1";
		StringBuilder query = new StringBuilder(queryForFetchDatadynamic);
        
		MapSqlParameterSource source=new MapSqlParameterSource();
		if (insertProductBean.getProductNm() != null) {
			//query.append(" AND LOWER(product_nm) LIKE '%' ||LOWER(:productNm)|| '%' ");
			query.append(" AND LOWER(product_nm) LIKE LOWER(:productNm)");
			source.addValue("productNm", "%" +insertProductBean.getProductNm() + "%");
			
		}
		if (insertProductBean.getProductCategory() != null) {
			query.append(" AND LOWER(product_category) LIKE '%' ||LOWER(:ProductCategory) || '%' ");
		}
		if (insertProductBean.getProductPrice() != null) {
			query.append(" AND product_Price>=:productPrice");
		}
		if (insertProductBean.getProductQty() != null) {
			query.append(" AND product_Qty=:productQty");
		}
		if (insertProductBean.getManufacturer() != null) {
			query.append(" AND manufacturer=:manufacturer");
		}
		String dynamicQuery = query.toString();
		System.out.println(dynamicQuery.toString());

		List<Map<String, Object>> list = namedParameterJdbcTemplate.queryForList(dynamicQuery,source);

		return list;

	}

}
