package org.nick.kindershop1.controller;

import org.nick.kindershop1.entity.category.Category;
import org.nick.kindershop1.jdbc.CategoryJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class HomeController {
	@Autowired
	CategoryJdbcDao categoryJdbcDao;
	
	@GetMapping("/")
	public String home(Model model){
		List<Category> topLevelCats = categoryJdbcDao.topLevelCategories();
		model.addAttribute("topCatsKey",topLevelCats);

		return "../static/index";
	}
	@GetMapping("/second")
	public String second(){
		return "../static/sec";
	}
	
	@GetMapping("/third")
	public String third(){
		return "../static/third";
	}
	
	@GetMapping("/fourth")
	public String fourth(){
		return "/fourth";
	}
	
	@GetMapping("/fifth")
	public String fifth(){
		return "../static/templ/fifth";
	}
	
	
}
