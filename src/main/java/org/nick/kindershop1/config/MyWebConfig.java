package org.nick.kindershop1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
	// Устанавливаем каталог статических файлов
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/imagesUp/**").addResourceLocations("file:D:/docs/kinder-pics/");
//		registry.addResourceHandler("/uploadImg/**").addResourceLocations("file:E:/idea/nlxx/hhxx/src/main/resources/static/uploadImg/");
	}
	
	
	
	
}