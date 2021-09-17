//package org.nick.kindershop1.service;
//
//import org.nick.kindershop1.entity.category.Category;
//import org.nick.kindershop1.repository.CategoryRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Service {
//	@Autowired
//	CategoryRepo categoryRepo;
//
//	/*
//	* 1) Получить категорию currCat по ПарентId
//	* 2) Взять из нее Id currCat.getId()
//	* 3) получить следующую новую(?) категорию по Id
//	*
//	* */
//
//	private void categoryListBuilder(int parId){
//		List<Category> crumbs = new ArrayList<>();
//
//
//		// 1 Parent id
//		List <Category> firstCategory = categoryRepo.findIdAndNameByParentId(parId);
////		int currId = firstCategory.getId();
//
//		if (firstCategory != null) {
////			crumbs.add(firstCategory);
//		}
//
//		// 2 Id
//		Category secondCategory = categoryRepo.findIdAndParentIdAndNameById(currId);
//		int currParId = secondCategory.getParentId();
//		currId = secondCategory.getId();
//
//		if (secondCategory != null) {
//			crumbs.add(secondCategory);
//		}
//
//		// 3 Parent Id
//		Category thirdCategory = categoryRepo.findIdAndParentIdAndNameById(currId);
//		currParId = thirdCategory.getParentId();
//		currId = thirdCategory.getId();
//
//		if (thirdCategory != null) {
//			crumbs.add(thirdCategory);
//		}
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
//
//	}
//
//
//
//	private int getCategoryParentId(int parId){
//		int resultId = categoryRepo.findIdAndNameByParentId(parId).getParentId();
//		return resultId;
//	}
//
//}
