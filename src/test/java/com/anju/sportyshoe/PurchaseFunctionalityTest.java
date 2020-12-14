package com.anju.sportyshoe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anju.sportyshoe.controller.PurchaseController;
import com.anju.sportyshoe.model.Product;
import com.anju.sportyshoe.model.Purchase;
import com.anju.sportyshoe.model.User;

@SpringBootTest
@DisplayName("Purchase Functionality Tests")
public class PurchaseFunctionalityTest {
	
	/*@Autowired
	private PurchaseController purchaseCtrl;

	@Test
	@DisplayName("Make A Purchase Functionality Test")
	void testMakePurchase() throws ParseException {
		Product product = new Product();
		product.setProductId(2);
		Purchase purchasePdt = new Purchase();
		purchasePdt.setProduct(product);
		purchasePdt.setPurchaseAmount(1200.98);
		User user = new User();
		user.setUserId(10);
		String sDate1="2020-10-18";  
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
		purchasePdt.setPurchasedBy(user);
		purchasePdt.setPurchaseDate(date1);
		Purchase purchasedPdt = purchaseCtrl.makePurchase(purchasePdt);
		assertNotNull(purchasedPdt);
	}
	
	@Test
	@DisplayName("Purchase Report Functionality Test")
	void testPurchaseReport() {
		List <Purchase> purchases = purchaseCtrl.purchaseReport();
		assertEquals(6, purchases.size());
	}
	
	@Test
	@DisplayName("Purchase Based on Date Test")
	void testPurchaseReportDate() throws ParseException {
		String sDate1 = "2020-10-12";  
	    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
		
		Purchase purchase = new Purchase();
		purchase.setPurchaseDate(date1);
		List <Purchase> purchases = purchaseCtrl.reportByDate(purchase);
		assertEquals(1, purchases.size());
	}
	
	@Test
	@DisplayName("Purchase Based on Category")
	void testReportByCategory() {
		Product product = new Product();
		product.setProductCategory("Womens Shoes");
		List <Purchase> purchases = purchaseCtrl.reportByCategory(product);
		assertEquals(3, purchases.size());
	}*/

}
