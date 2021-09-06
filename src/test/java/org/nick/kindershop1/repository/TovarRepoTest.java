package org.nick.kindershop1.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.nick.kindershop1.entity.product.Tovar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TovarRepoTest {
	
	@Autowired
	TovarRepo tovarRepo;
	
	@Test
	void findAll() {
		Iterable<Tovar> all = tovarRepo.findAll();
		System.out.println(	 all.toString());
	}
	
	@Test
	void findAllByIdOrderByPriceAsc() {
//		List<Tovar> listTov = tovarRepo.findAllByIdOrderByPriceAsc(264356);
		System.out.println(tovarRepo.findAllByIdOrderByPriceAsc(264354));
	}
	
	@Test
	public void findById() {
		System.out.println(tovarRepo.findById(264357));
	}
}