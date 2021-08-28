package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageMapper implements RowMapper<List> {
	
	@Override
	public List mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		System.out.println("\n>>>>>>>>>>>>>>>>>>"+rs.getMetaData());
		Product imageMapProd = new Product();
		List <String> images = new ArrayList();
		
			images.add(rs.getString("image"));
//		while (rs.next()) {
//		}
		imageMapProd.setImgArray(images);
		System.out.println("\n<<<<<<<<<<<<<<<"+images);
		
		
//		return imageMapProd;
		return images;
	}
}
