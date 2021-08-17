package org.nick.kindershop1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {
	// Устанавливаем каталог статических файлов
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/uploadImg/**").addResourceLocations("file:E:/idea/nlxx/hhxx/src/main/resources/static/uploadImg/");
	}
}