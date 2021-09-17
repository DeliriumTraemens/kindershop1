package org.nick.kindershop1.repository;

import org.nick.kindershop1.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	List<Category> findAllByParentIdAndStatus(int id, short status);
	
	List<Category> findIdAndNameByParentId(int catParId);
	
	List<Category> findIdAndParentIdAndNameById(int currId);
}
