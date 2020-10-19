package com.anju.sportyshoe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anju.sportyshoe.exception.ProductNotFoundException;
import com.anju.sportyshoe.model.Product;
import com.anju.sportyshoe.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	/*create new product*/
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return this.productRepo.save(product);
	}
	
	/*list all products*/
	@GetMapping("/")
	public List <Product> listProduct() {
		return this.productRepo.findAll();
	}
	
	/*edit a particular product*/
	@PutMapping("/save/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable(value="id") Integer productId) {
		Product toEdit = this.productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("Invalid product chosen for editing.."));
		toEdit.setProductName(product.getProductName());
		toEdit.setProductPrice(product.getProductPrice());
		toEdit.setProductCategory(product.getProductCategory());
		toEdit.setProductColor(product.getProductColor());
		toEdit.setProductSpecification(product.getProductSpecification());
		toEdit.setProductDescription(product.getProductDescription());
		return this.productRepo.save(toEdit);
	}
	
	/*delete a product*/
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable(value="id") Integer productId) {
		Product toDelete = this.productRepo.findById(productId).orElseThrow(()-> new ProductNotFoundException("Invalid product chosen for deletion.."));
		this.productRepo.delete(toDelete);
	}
}
