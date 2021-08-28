package org.nick.kindershop1.controller;

import org.nick.kindershop1.entity.category.Category;
import org.nick.kindershop1.entity.product.Product;
import org.nick.kindershop1.jdbc.CategoryJdbcDao;
import org.nick.kindershop1.jdbc.ProductJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
//@RequestMapping("/")
public class HomeController {
	@Autowired
	CategoryJdbcDao categoryJdbcDao;
	
	@Autowired
	ProductJdbcDao productJdbcDao;
	
	@GetMapping("/")
	public String home(Model model){
		List<Category> topLevelCats = categoryJdbcDao.topLevelCategories();
		model.addAttribute("topCatsKey",topLevelCats);

		return "../static/index";
	}
	
	@GetMapping("/subcategory/{id}")
	public String subcategoryId(@PathVariable(value = "id") int id, Model model){
		model.addAttribute("subCatList", categoryJdbcDao.subCategoryes(id));
		return "/subcategory";
	}
	
	@GetMapping("/subcategoryProd/{id}")
	public String subCatProd(@PathVariable(value = "id") int id, Model model){
		model.addAttribute("subCategList", categoryJdbcDao.subCategoryes(id));
		model.addAttribute("subCatProd",productJdbcDao.getAllProduct(id));
		return "/subactproduct";
	}
	
	@GetMapping("/product/{id}")
	public String /*getProduct*/findOneWithImagesById(@PathVariable(value = "id") int id, Model model){
		model.addAttribute("productCard",productJdbcDao./*findOneById*/findOneWithImagesById(id));
		System.out.println(model.toString());
		
		return "/product";
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
