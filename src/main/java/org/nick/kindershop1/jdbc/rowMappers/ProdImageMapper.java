package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.product.ProdImage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//
public class ProdImageMapper implements RowMapper<ProdImage> {
	//В параметрах просто Объект, который мы маппим!!! Лист из объектов делается этажом выше -в DAO!!!
	@Override
	public ProdImage mapRow(ResultSet rs, int rowNum) throws SQLException {
		
//		List <ProdImage> images = new ArrayList();
		
		ProdImage prodImage=new ProdImage();
		prodImage.setName(rs.getString("image"));
		
//		images.add(prodImage);
		return prodImage;
	}
}
