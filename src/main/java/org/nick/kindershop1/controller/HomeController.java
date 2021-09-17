package org.nick.kindershop1.controller;

import org.nick.kindershop1.entity.category.Category;
import org.nick.kindershop1.jdbc.CategoryJdbcDao;
//import org.nick.kindershop1.jdbc.ProductJdbcDao;
import org.nick.kindershop1.jdbc.ProductJdbcDao;
import org.nick.kindershop1.repository.CategoryRepo;
import org.nick.kindershop1.repository.TovarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	
	@Autowired
	TovarRepo tovarRepo;
	
	
	@ModelAttribute
	public void addMainCategories(Model model) {
		model.addAttribute("catalog", categoryRepo.findAllByParentIdAndStatus(0, (short) 1));
	}
	
	
	@GetMapping("/")
	public String home(Model model){
//		List<Category> topLevelCats = categoryJdbcDao.topLevelCategories();
		List<Category> topLevelCats = categoryRepo.findAllByParentIdAndStatus(0, (short) 1);
		model.addAttribute("topCatsKey",topLevelCats);
		
//		List<Category> topCategList = categoryRepo.findAllByParentIdAndStatus(1130, (short) 1);
//		System.out.println("\n\n\n-------JPA TEST-------\n"+topLevelCats+"\n\n\n-------JPA TEST-------\n\n");

		return "../static/index";
	}
	
	@GetMapping("/subcategory/{id}")
	public String subcategoryId(@PathVariable(value = "id") int id, Model model){
//		model.addAttribute("subCatList", categoryJdbcDao.subCategoryes(id));
		model.addAttribute("subCatList", categoryRepo.findAllByParentIdAndStatus(id, (short) 1));
		return "/subcategory";
	}
	
	@GetMapping("/subcategoryProd/{id}")
	public String subCatProd(@PathVariable(value = "id") int id, Model model, @RequestParam(defaultValue="0") int page){
		model.addAttribute("subCategList", categoryRepo.findAllByParentIdAndStatus(id, (short) 1));
		model.addAttribute("subCatProd",tovarRepo.findByCategoryId(id, PageRequest.of(page, 16)));
		
		model.addAttribute("currentPage",page);
		model.addAttribute("catId",id);
		
		
//		System.out.println("\n Tovar List\n"+tovarRepo.findByCategoryId(id));
		return "/subactproduct";
	}
	
	@GetMapping("/product/{id}")
	public String findOneByIdFullImageList(@PathVariable(value = "id") int id, Model model){
//
//		model.addAttribute("productCard",productJdbcDao.findOneWithImagesById(id));
		model.addAttribute("productCardJpa",tovarRepo.findById(id));
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
