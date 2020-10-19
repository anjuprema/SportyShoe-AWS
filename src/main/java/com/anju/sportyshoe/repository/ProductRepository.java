package com.anju.sportyshoe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anju.sportyshoe.model.Product;
import com.anju.sportyshoe.model.Purchase;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer>{
	public List <Product> findByproductCategory(String category);
}
