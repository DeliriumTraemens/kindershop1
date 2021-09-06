package org.nick.kindershop1.repository;

import org.nick.kindershop1.entity.product.Tovar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TovarRepo extends JpaRepository<Tovar,Integer> {
	List<Tovar> findAllByIdOrderByPriceAsc(int id);
	List<Tovar> findById(int id);
	List<Tovar> findByCategoryId(int id);
}
