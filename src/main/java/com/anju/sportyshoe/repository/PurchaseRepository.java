package com.anju.sportyshoe.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anju.sportyshoe.model.Product;
import com.anju.sportyshoe.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	public List <Purchase> findBypurchaseDate(Date date);
	
	public List <Purchase> findByproduct(Product product);
}
