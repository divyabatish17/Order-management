package com.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CustomerDto;
import com.entity.CustomerModel;
import com.repository.CustomerRepository;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	


	@Override
	public String createCustomer(CustomerDto customerDto) {
		try {
			CustomerModel customer = new CustomerModel();
			customer.setCity(customerDto.getCity());
			customer.setCreatedBy(customerDto.getUsername());
			customer.setCreatedDate(new Date());
			customer.setDistrict(customerDto.getDistrict());
			customer.setEmail(customerDto.getEmail());
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setLatitude(customerDto.getLatitude());
			customer.setLongitude(customerDto.getLongitude());
			customer.setMobileNumber(customerDto.getMobileNumber());
			customer.setPincode(customerDto.getPincode());
			customer.setStatus(true);
			customer.setStreet(customerDto.getStreet());
			customer.setUsername(customerDto.getUsername());
			customer.setUserType("Regular");
			CustomerModel save = customerRepository.save(customer);
			if (save != null) {
				return "Customer Created Successfully";
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return "Exception while creating customer";
	}
}
