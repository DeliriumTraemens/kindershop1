package org.nick.kindershop1.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.nick.kindershop1.entity.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
		List<Category> crumbs = new ArrayList<>();
		List<String>catnames=new ArrayList<>();
		System.out.println(crumbs);
		int currParId = 1270;
		int currId = currParId;
		
		// 1 Parent id
		List <Category> firstCategory = categoryRepo.findIdAndNameByParentId(currParId);
		System.out.println("\n После первого вызова по ParentID "+firstCategory.get(0));
		
		crumbs.add(firstCategory.get(0));
		catnames.add(firstCategory.get(0).getCatName());
//
//		// 2 Id
		List <Category> secondCategory = categoryRepo.findIdAndParentIdAndNameById(currId);
		System.out.println("\n После вызова по Id "+secondCategory.get(0));
		crumbs.add(secondCategory.get(0));
		catnames.add(secondCategory.get(0).getCatName());


//		System.out.println("\n<---------->\ncrumbs contains "+crumbs);

//
//
//		// 3 Parent Id
		int nextParent = secondCategory.get(0).getParentId();
		List <Category> thirdCategory = categoryRepo.findIdAndParentIdAndNameById(nextParent);
//		currParId = thirdCategory.getParentId();
//		currId = thirdCategory.getId();
//
//		if (thirdCategory != null) {
			crumbs.add(thirdCategory.get(0));
			catnames.add(thirdCategory.get(0).getCatName());
//		}
//
		System.out.println("\n После первого вызова по ParentID "+firstCategory.get(0));
		System.out.println("\n После вызова по Id "+secondCategory.get(0));
		
		System.out.println("\n После второго вызова по ParentID "+thirdCategory.get(0));
		
		System.out.println("\n<---------->\ncrumbs contains "+crumbs);
		System.out.println("\n<---------->\ncrumbs contains "+catnames);


//
//
//		// 4  Id
//		Category fourthCategory = categoryRepo.findIdAndParentIdAndNameById(currId);
//		currParId = fourthCategory.getParentId();
//		currId = fourthCategory.getId();
//
//		if (fourthCategory != null) {
//			crumbs.add(fourthCategory);
//		}
//
//		System.out.println(crumbs);
//
//
//		// 5  Id
//		Category fifthCategory = categoryRepo.findIdAndParentIdAndNameById(currId);
//		currParId = fifthCategory.getParentId();
//		currId = fifthCategory.getId();
//
//		if (fifthCategory != null) {
//
//			crumbs.add(fifthCategory);
//		}
//
//		System.out.println(crumbs);
		
	}

}