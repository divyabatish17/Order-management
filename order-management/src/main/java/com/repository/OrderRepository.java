package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.entity.OrderModel;

@SuppressWarnings("unused")
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel>{

}
