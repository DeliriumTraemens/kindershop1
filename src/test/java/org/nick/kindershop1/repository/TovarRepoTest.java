package org.nick.kindershop1.repository;

import org.junit.jupiter.api.Test;
import org.nick.kindershop1.entity.product.Tovar;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TovarRepoTest {
	
	@Autowired
	TovarRepo tovarRepo;
	
	@Test
	void findAll() {
		Iterable<Tovar> all = tovarRepo.findAll();
		System.out.println(	 all.toString());
	}
}