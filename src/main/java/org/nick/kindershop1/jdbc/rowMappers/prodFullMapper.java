package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class prodFullMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		List<String> images = new ArrayList<>();
		System.out.println("\n RS\n"+rs.getMetaData());
		
		product.setId(rs.getInt("p.product_id"));
		product.setName(rs.getString("opd.name"));
		product.setDescription(rs.getString("opd.description"));
		product.setImageUrl(rs.getString("p.image"));
		product.setPrice(rs.getFloat("p.price"));
		images.add(rs.getString("opi.image"));
		
		
		return product;
		
	}
}
