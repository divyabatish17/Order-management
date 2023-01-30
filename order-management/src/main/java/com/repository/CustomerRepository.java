package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.entity.CustomerModel;

@SuppressWarnings("unused")

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>, JpaSpecificationExecutor<CustomerModel>{

	@Query(value = "SELECT * FROM customer where username = :userName", nativeQuery = true)
	public CustomerModel getByUsername(String userName);
	
	@Query(value = "update customer set total_discount=:totalDiscount where username = :userName", nativeQuery = true)
	public int updateTotalDiscount(String userName, Double totalDiscount);
	
	@Query(value = "update customer set customer_order_count=:totalDiscount where username = :userName", nativeQuery = true)
	public int updateOrderCount(String userName, Double count);
	
	@Query(value = "update customer set user_type=:type where username = :userName", nativeQuery = true)
	public int updateUserType(String userName, String type);
	
	
}
