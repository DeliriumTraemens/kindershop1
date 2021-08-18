package org.nick.kindershop1.jdbc.rowMappers;

import org.nick.kindershop1.entity.category.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper <Category>{
	@Override
	public Category mapRow(ResultSet resultSet, int i) throws SQLException {
		
		Category category = new Category();
		
//		System.out.println("\n RS\n"+resultSet.getMetaData());
		
		category.setId(resultSet.getInt("oc_category.category_id"));
		category.setImageUrl(resultSet.getString("oc_category.image"));
		category.setCatName(resultSet.getString("oc_category_description.name"));
		
		
		return category;
	}
}
