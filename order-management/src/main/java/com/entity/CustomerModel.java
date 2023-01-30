package com.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CustomerModel {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "mobile_number", nullable = false, unique = true)
	private String mobileNumber;

	@NotNull
	@Column(name = "user_type", nullable = false)
	private String userType;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "latitude", precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", precision = 11, scale = 8)
	private BigDecimal longitude;

	@Column(name = "district")
	private String district;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "customer_order_count")
	private Long orderCount;
	
	@Column(name = "total_discount")
	private Double totalDiscount;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customerModel")
	private Set<OrderModel> customerOrder = new HashSet<OrderModel>();

	public Set<OrderModel> getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(Set<OrderModel> customerOrder) {
		this.customerOrder = customerOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public CustomerModel() {
		super();
	}
	public CustomerModel(Long id, String email, @NotNull String firstName, String lastName, String username,
			String mobileNumber, @NotNull String userType, Boolean status, String pincode, String city, String street,
			BigDecimal latitude, BigDecimal longitude, String district, Date createdDate, String createdBy,
			Long orderCount, Double totalDiscount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.userType = userType;
		this.status = status;
		this.pincode = pincode;
		this.city = city;
		this.street = street;
		this.latitude = latitude;
		this.longitude = longitude;
		this.district = district;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.orderCount = orderCount;
		this.totalDiscount = totalDiscount;
	}
	
	
	
}
