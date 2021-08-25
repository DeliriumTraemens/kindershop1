package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.category.Category;
import org.nick.kindershop1.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		System.out.println("\n RS\n"+rs.getMetaData());
		
		product.setId(rs.getInt("p.product_id"));
		product.setCategoryId(rs.getInt("optc.category_id"));
		product.setName(rs.getString("opd.name"));
		product.setDescription(rs.getString("opd.description"));
		product.setImageUrl(rs.getString("p.image"));
		product.setPrice(rs.getFloat("p.price"));
		
//		product.setId(rs.getInt("oc_product.product_id"));
//		product.setCategoryId(rs.getInt("oc_product_to_category.category_id"));
//		product.setName(rs.getString("oc_product_description.name"));
//		product.setDescription(rs.getString("oc_product_description.description"));
//		product.setImageUrl(rs.getString("oc_product.image"));
//
		System.out.println(product);
		
		return product;
	}
}
