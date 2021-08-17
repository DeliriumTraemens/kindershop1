package org.nick.kindershop1;

import org.nick.kindershop1.jdbc.CategoryJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Kindershop1Application/* implements CommandLineRunner */{
	
//	public Kindershop1Application(CategoryJdbcDao categoryJdbcDao) {
//		this.categoryJdbcDao = categoryJdbcDao;
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(Kindershop1Application.class, args);
	}
	
//	final CategoryJdbcDao categoryJdbcDao;
//
//	@Override
//	public void run(String... args) throws Exception {
//
////		categoryJdbcDao.topLevelCategories();
//		System.out.println(categoryJdbcDao.topLevelCategories());
//
//
//	}
}
