package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "customer_order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OrderModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private Double productPrice;
	
	@Column(name = "product_quantity")
	private Integer productQuantity;
	
	@Column(name = "is_discount_avail")
	private Boolean isDiscountAvail;
	
	@Column(name = "total_amt")
	private Double totalAmount;
	
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@ManyToOne
	private CustomerModel customerModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Boolean getIsDiscountAvail() {
		return isDiscountAvail;
	}

	public void setIsDiscountAvail(Boolean isDiscountAvail) {
		this.isDiscountAvail = isDiscountAvail;
	}

	

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public OrderModel(Long id, String productName, Double productPrice, Integer productQuantity,
			Boolean isDiscountAvail) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.isDiscountAvail = isDiscountAvail;
	}
	public OrderModel() {
		super();
	}

	
}
