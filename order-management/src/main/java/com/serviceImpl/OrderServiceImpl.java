package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.OrderDto;
import com.entity.CustomerModel;
import com.entity.OrderModel;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public OrderDto saveOrder(OrderDto orderDto) {
		OrderModel order = new OrderModel();
		if(!orderDto.getCustomerDto().getUsername().isEmpty()) {
			CustomerModel userDetails = customerRepository.getByUsername(orderDto.getCustomerDto().getUsername());
			if(userDetails.getOrderCount() >= 10 && userDetails.getOrderCount() < 20){
				order.setIsDiscountAvail(true);
				Double discount = (orderDto.getProductPrice()*10)/100;
				order.setTotalAmount(orderDto.getTotalAmount() - discount);
				customerRepository.updateTotalDiscount(orderDto.getCustomerDto().getUsername(),userDetails.getTotalDiscount() + discount);
				customerRepository.updateUserType(orderDto.getCustomerDto().getUsername(), "Gold");
			}
			else if(userDetails.getOrderCount() >= 20) {
				order.setIsDiscountAvail(true);
				Double discount = (orderDto.getProductPrice()*20)/100;
				order.setTotalAmount(orderDto.getTotalAmount() - discount);
				customerRepository.updateTotalDiscount(orderDto.getCustomerDto().getUsername(),userDetails.getTotalDiscount() + discount);
				customerRepository.updateUserType(orderDto.getCustomerDto().getUsername(), "Platinum");
			}
			order.setCustomerModel(userDetails);
			order.setIsDiscountAvail(false);
			order.setProductName(orderDto.getProductName());
			order.setProductPrice(orderDto.getProductPrice());
			order.setProductQuantity(orderDto.getProductQuantity());
			order.setTotalAmount(orderDto.getTotalAmount());
			order.setProductQuantity(orderDto.getProductQuantity());
			}
		OrderModel result = orderRepository.save(order);
		if(result != null) {
			return orderDto;
		}
		return null;
	}

}
