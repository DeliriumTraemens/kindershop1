package org.nick.kindershop1.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.nick.kindershop1.entity.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryRepoTest {
	@Autowired
	CategoryRepo categoryRepo;
	
	@Test
	void findAllByParentIdAndStatus() {
		List<Category> categoryList = categoryRepo.findAllByParentIdAndStatus(0, (short) 1);
	}
	
	@Test
	public void categoryListBuilder(){
//		List<Category> crumbs = new ArrayList<>();
//		List<String>catnames=new ArrayList<>();
//		System.out.println(crumbs);
//		int currParId = 1545;
//		int currId = currParId;
//
//		// 1 Parent id
//		List <Category> firstCategory = categoryRepo.findIdAndNameByParentId(currParId);
//		System.out.println("\n После первого вызова по ParentID "+firstCategory.get(0));
//
//		crumbs.add(firstCategory.get(0));
//		catnames.add(firstCategory.get(0).getCatName());
////
////		// 2 Id
//		List <Category> secondCategory = categoryRepo.findIdAndParentIdAndNameById(currId);
//		System.out.println("\n После вызова по Id "+secondCategory.get(0));
//		crumbs.add(secondCategory.get(0));
//		catnames.add(secondCategory.get(0).getCatName());
//
////
////		// 3 Parent Id
//		int nextParent = secondCategory.get(0).getParentId();
//		List <Category> thirdCategory = categoryRepo.findIdAndParentIdAndNameById(nextParent);
//			crumbs.add(thirdCategory.get(0));
//			catnames.add(thirdCategory.get(0).getCatName());
////		}
////
//		System.out.println("\n После первого вызова по ParentID "+firstCategory.get(0));
//		System.out.println("\n После вызова по Id "+secondCategory.get(0));
//
//		System.out.println("\n После второго вызова по ParentID "+thirdCategory.get(0));
//
//		System.out.println("\n<---------->\ncrumbs contains "+crumbs);
//		System.out.println("\n<---------->\ncrumbs contains "+catnames);
		
	}
	
	@Test
	void buildList(){
		catBuilder(1305);
	}
	public List<Category> catBuilder(int Id){
		
		List <Category> crumbList = new ArrayList();
		List<Category> crumbs = new ArrayList();
		List<String> crumbsBread = new ArrayList();
		List<String> breadCrumbs = new ArrayList();
		Category current= firstCrumb(Id);
		
		crumbList.add(current);
		crumbsBread.add(current.getCatName()+"/");
		
		while (current.getParentId()!=0){
			current=firstCrumb(current.getParentId());
			crumbList.add(current);
			crumbsBread.add(current.getCatName()+"/");
		}
		
		for(int i = crumbsBread.size()-1 ; i>=0 ; i--){
			breadCrumbs.add(crumbsBread.get(i));
		}
		
		for(int i = crumbList.size()-1 ; i>=0 ; i--){
			crumbs.add(crumbList.get(i));
		}
		
		System.out.println("\n CrumbList is "+crumbList);
		System.out.println("\n CrumbList reversed is "+crumbs);
		System.out.println("\n CrumbList names are "+crumbsBread);
		System.out.println("\n CrumbList names finally are "+breadCrumbs);
		return crumbs;
	}
	
	public Category firstCrumb(int id){
		return categoryRepo.findIdAndParentIdAndNameById(id);
	}
	
	
	public Category categoryByParentId(int parentId){
		int nextParentId;
		Category catByParent = categoryRepo.findIdAndNameByParentId(parentId).get(0);
		return  catByParent;
	}

}