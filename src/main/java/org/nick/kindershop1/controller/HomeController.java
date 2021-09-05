package org.nick.kindershop1.controller;

import org.nick.kindershop1.entity.category.Category;
import org.nick.kindershop1.jdbc.CategoryJdbcDao;
//import org.nick.kindershop1.jdbc.ProductJdbcDao;
import org.nick.kindershop1.jdbc.ProductJdbcDao;
import org.nick.kindershop1.repository.CategoryRepo;
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
	
	@Autowired
	CategoryRepo categoryRepo;
	
	
	
	@GetMapping("/")
	public String home(Model model){
//		List<Category> topLevelCats = categoryJdbcDao.topLevelCategories();
		List<Category> topLevelCats = categoryRepo.findAllByParentIdAndStatus(0, (short) 1);
		model.addAttribute("topCatsKey",topLevelCats);
		
//		List<Category> topCategList = categoryRepo.findAllByParentIdAndStatus(1130, (short) 1);
		System.out.println("\n\n\n-------JPA TEST-------\n"+topLevelCats+"\n\n\n-------JPA TEST-------\n\n");

		return "../static/index";
	}
	
	@GetMapping("/subcategory/{id}")
	public String subcategoryId(@PathVariable(value = "id") int id, Model model){
//		model.addAttribute("subCatList", categoryJdbcDao.subCategoryes(id));
		model.addAttribute("subCatList", categoryRepo.findAllByParentIdAndStatus(id, (short) 1));
		return "/subcategory";
	}
	
	@GetMapping("/subcategoryProd/{id}")
	public String subCatProd(@PathVariable(value = "id") int id, Model model){
//		model.addAttribute("subCategList", categoryJdbcDao.subCategoryes(id));
		model.addAttribute("subCategList", categoryRepo.findAllByParentIdAndStatus(id, (short) 1));
//		model.addAttribute("subCatProd",productRepo.findAllByCategoryId(id));
		model.addAttribute("subCatProd",productJdbcDao.getAllProduct(id));
		return "/subactproduct";
	}
	
	@GetMapping("/product/{id}")
	public String findOneByIdFullImageList(@PathVariable(value = "id") int id, Model model){
//
		model.addAttribute("productCard",productJdbcDao.findOneWithImagesById(id));
//		System.out.println("\n>>>картинкес<<<\n"+productJdbcDao.collectProdimages(id)+"\n>>>-------------<<<\n");
//
		return "../static/product";
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
