package com.anju.sportyshoe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="purchase_id")
	private int purchaseId;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User purchasedBy;
	
	@Column(name="purchase_date")
	private Date purchaseDate;
	
	@Column(name="purchase_amount")
	private Double purchaseAmount;
	
	
	public Purchase() {
		super();
	}	

	public Purchase(Product product, User purchasedBy, Date purchaseDate, Double purchaseAmount) {
		super();
		this.product = product;
		this.purchasedBy = purchasedBy;
		this.purchaseDate = purchaseDate;
		this.purchaseAmount = purchaseAmount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public User getPurchasedBy() {
		return purchasedBy;
	}
	public void setPurchasedBy(User purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	
}
