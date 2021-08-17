package org.nick.kindershop1.jdbc;

import org.nick.kindershop1.entity.category.Category;
import org.nick.kindershop1.jdbc.rowMappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryJdbcDao {
	
	final JdbcTemplate jdbcTemplate;
	
	public CategoryJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Category> topLevelCategories(){
		List<Category> topLevelCats = jdbcTemplate.query("select oc_category.category_id," +
				                                                 "oc_category.image," +
				                                                 " oc_category_description.name " +
				                                                 "from oc_category " +
				                                                 "join oc_category_description " +
				                                                 "on oc_category.category_id =oc_category_description.category_id " +
				                                                 "where oc_category.parent_id = 0 and oc_category.status =1", new CategoryMapper());
		return topLevelCats;
	}
	
}
