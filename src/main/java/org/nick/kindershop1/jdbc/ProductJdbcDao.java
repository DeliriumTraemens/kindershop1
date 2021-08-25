package org.nick.kindershop1.jdbc;

import org.nick.kindershop1.entity.product.Product;
import org.nick.kindershop1.jdbc.rowMappers.ProductMapper;
import org.nick.kindershop1.jdbc.rowMappers.prodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductJdbcDao {
	final
	JdbcTemplate jdbcTemplateProd;
	
	public ProductJdbcDao(JdbcTemplate jdbcTemplateProd) {
		this.jdbcTemplateProd = jdbcTemplateProd;
	}
	
	
	public List<Product> getAllProduct(int catId){
		return jdbcTemplateProd.query("select p.product_id, p.price, p.image, opd.name, opd.description, optc.category_id " +
				                          "from oc_product p join oc_product_description opd join oc_product_to_category optc " +
				                          "on opd.product_id=p.product_id and optc.product_id=p.product_id and category_id=?",
		                              new Object[]{catId},
		                              new ProductMapper());
	}
	
	public List<Product> getProduct(int id) {
		List<Product> products= jdbcTemplateProd.query("select p.product_id, p.image, p.price, opd.name, opd.description " +
				                          "from oc_product p join oc_product_description opd " +
				                          "on opd.product_id = p.product_id " +
				                          "where p.product_id=?",
		                                               new Object[]{id},
		                                               new prodMapper());
		
		return products;
	
	}
	
	public Product findOneById(int id){
		return jdbcTemplateProd.queryForObject("select p.product_id, p.image, p.price, opd.name, opd.description " +
				                                       "from oc_product p join oc_product_description opd " +
				                                       "on opd.product_id = p.product_id " +
				                                       "where p.product_id=?",  new prodMapper(),new Object[]{id});
	}
}
