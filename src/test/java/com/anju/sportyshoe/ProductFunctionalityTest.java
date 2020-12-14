package com.anju.sportyshoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anju.sportyshoe.controller.ProductController;
import com.anju.sportyshoe.model.Product;

@DisplayName("Product Functionality Tests")
@SpringBootTest
public class ProductFunctionalityTest {
	
	/*@Autowired
	ProductController pdtCtrl;
	
	@Test
	@DisplayName("Product Creation Test")
	void testSaveProduct() {
		Product product = new Product();
		product.setProductCategory("Kids Shoes");
		product.setProductColor("Purple And Green");
		product.setProductDescription("Purple and Green Kids Shoes 12 inches");
		product.setProductName("Boots Kids Shoes");
		product.setProductPrice(1200.00);
		product.setProductSpecification("12 inches kids shoes");
		
		Product savedProduct = this.pdtCtrl.saveProduct(product);
		assertNotNull(savedProduct);
	}
	
	@Test
	@DisplayName("Product Listing Test")
	void testListProduct() {
		List <Product> pdtList = pdtCtrl.listProduct();
		assertEquals(5,pdtList.size());
	}
	
	@Test
	@DisplayName("Update Product Details Test")
	void testUpdateProduct() {
		Product product = new Product();
		product.setProductCategory("Mens Shoes");
		product.setProductColor("Purple And Green");
		product.setProductDescription("Purple and Green Kids Shoes 22 inches");
		product.setProductName("Boots Mens Shoes");
		product.setProductPrice(2200.00);
		product.setProductSpecification("22 inches kids shoes");
		
		Product updatedPdt = pdtCtrl.updateProduct(product, 7);
		assertNotNull(updatedPdt);
	}
	
	@Test
	@DisplayName("Delete Product Test")
	void testDeleteProduct() {
		pdtCtrl.deleteProduct(7);
	}*/
}
