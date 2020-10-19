package com.anju.sportyshoe.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anju.sportyshoe.model.Product;
import com.anju.sportyshoe.model.Purchase;
import com.anju.sportyshoe.repository.ProductRepository;
import com.anju.sportyshoe.repository.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	private static final boolean Product = false;
	@Autowired
	public PurchaseRepository purchaseRepo;
	@Autowired
	public ProductRepository productRepo;
	
	/*make purchase*/
	@PostMapping("/save")
	public Purchase makePurchase(@RequestBody Purchase purchase) {
		return purchaseRepo.save(purchase);
	}
	
	/*get all purchase report*/
	@GetMapping("/report")
	public List <Purchase> purchaseReport(){
		return purchaseRepo.findAll();
	}
	
	/*filter purchase report by date*/
	@PostMapping("/report/date")
	public List <Purchase> reportByDate(@RequestBody Purchase purchase) {
		return purchaseRepo.findBypurchaseDate(purchase.getPurchaseDate());
	}
	
	/*filter purchase report by category*/
	@PostMapping("/report/category")
	public List <Purchase> reportByCategory(@RequestBody Product product){
		List <Product> pdtList = this.productRepo.findByproductCategory(product.getProductCategory());
		List <Purchase> purchaseList = new ArrayList<Purchase>();
		for(Product pdt: pdtList){
			purchaseList.addAll(this.purchaseRepo.findByproduct(pdt));
		}
		return purchaseList;
	}
}
