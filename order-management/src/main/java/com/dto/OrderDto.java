package com.dto;

public class OrderDto {

	private String productName;
	
	private Double productPrice;

	private Integer productQuantity;

	private Boolean isDiscountAvail;

	private CustomerDto customerDto;
	
	private Double totalAmount;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
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

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}


	
	
}
