package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageMapper implements RowMapper<List> {
	//В параметрах просто List без дженерика????
	@Override
	public List mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		List <String> images = new ArrayList();
			images.add(rs.getString("image"));
		return images;
	}
}
