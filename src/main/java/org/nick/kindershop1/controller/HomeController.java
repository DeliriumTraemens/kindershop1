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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
		List<Category> topLevelCats = categoryRepo.findAllByParentIdAndStatus(0, (short) 1);
		model.addAttribute("topCatsKey",topLevelCats);
		

		return "../static/index";
	}
	
	@GetMapping("/subcategory/{id}")
	public String subcategoryId(@PathVariable(value = "id") int id, Model model){
		model.addAttribute("crumbs",catBuilder(id));
		model.addAttribute("subCatList", categoryRepo.findAllByParentIdAndStatus(id, (short) 1));
		return "/subcategory";
	}
	
	int currentSubcat;
	
	@GetMapping("/subcategoryProd/{id}")
	public String subCatProd(@PathVariable(value = "id") int id, Model model, @RequestParam(defaultValue="0") int page){
		model.addAttribute("subCategList", categoryRepo.findAllByParentIdAndStatus(id, (short) 1));
		model.addAttribute("subCatProd",tovarRepo.findByCategoryId(id, PageRequest.of(page, 16)));
		
		model.addAttribute("breadCrumbs",catBuilder(id));
		model.addAttribute("currentPage",page);
		model.addAttribute("catId",id);
		currentSubcat=id;
		
		return "/subactproduct";
	}
	
	@GetMapping("/subcategoryProdEdit/{id}")
	public String subcategoryEdit(@PathVariable(value = "id") int id, Model model){
		Optional<Category> catsEdit=categoryRepo.findById(id);
		Category catToEdit=catsEdit.get();
		model.addAttribute("catEdit",catToEdit);
		return "/subcategoryEdit";
	}
	
	@PostMapping("/subcategoryProdEdit/editCat")
	public String categoryProdEditChange(){
		return "/blanc";
	}
	
	@PostMapping("/picture")
	public String pictureAdd(@RequestParam("file") MultipartFile file) throws IOException  {
		return "/blanc";
	}
	
	 @GetMapping("/picture")
	 public String pictureChooser(){
		 System.out.println("\n\nHHHHHHHHHHHHHHHHHHHH**********************HHHHHHHHHHHHHHHHHHHHHHHHHHHHH\n\n");
		 return "/formPicture";
	 }
	 
	 @PostMapping("/getPicture")
	 public String pictureGet (@RequestParam("file") MultipartFile file) throws IOException{
		
		 if (file!=null && !file.getOriginalFilename().isEmpty()) {
			
		 }
		
		
		System.out.println("\n\n----------------------**********************----------------------\n\n");
		System.out.println(file.toString());
		System.out.println(file.getBytes().toString());
		System.out.println(file.getOriginalFilename());
		System.out.println("\n\n----------------------**********************----------------------\n\n");
		
		
		
		 return "/formPicture";
	 }
	
	
	@GetMapping("/product/{id}")
	public String findOneByIdFullImageList(@PathVariable(value = "id") int id, Model model){
//
		model.addAttribute("productCardJpa",tovarRepo.findById(id));
		model.addAttribute("breadCrumbs",catBuilder(currentSubcat));

//
		return "../static/product";
	}
	
	@PostMapping("/categoruPic")
	public String categoryPictureChange(Category category, @RequestParam("file") MultipartFile file) throws IOException {
		
		System.out.println(category);
		System.out.println("---------------\n");
		System.out.println(file);
	return "/subcategory";
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
	
	//----------------- SERVICE -------------------\\
	
	public List<Category> catBuilder(int id){
		
//		List <Category> crumbList = new ArrayList();
		LinkedList <Category> crumbList = new LinkedList();
		List<Category> crumbs = new ArrayList();
		
//		Category current= firstCrumb(id);
		Category current= categoryRepo.findIdAndParentIdAndNameById(id);
		
		crumbList.addFirst(current);
		
			while (current.getParentId()!=0){
//				current=firstCrumb(current.getParentId());
				current=categoryRepo.findIdAndParentIdAndNameById(current.getParentId());
				crumbList.addFirst(current);
			}
			
			
//			for(int i = crumbList.size()-1 ; i>=0 ; i--){
//				crumbs.add(crumbList.get(i));
//			}
		
//		return crumbs;
		return crumbList;
	}
	
	public Category firstCrumb(int id){
		return categoryRepo.findIdAndParentIdAndNameById(id);
	}
	
	
}
