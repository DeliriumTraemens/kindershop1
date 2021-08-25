package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class prodMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		
		
		product.setId(rs.getInt("p.product_id"));
		product.setName(rs.getString("opd.name"));
		product.setDescription(rs.getString("opd.description"));
		product.setImageUrl(rs.getString("p.image"));
		product.setPrice(rs.getFloat("p.price"));
		return product;
	}
}
