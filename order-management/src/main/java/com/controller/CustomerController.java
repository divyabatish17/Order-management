package com.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CustomerDto;
import com.exception.BadRequestAlertException;
import com.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	 private final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;
	
	
	 /**
     * {@code POST  /create-customer} : Create a new customer.
     *
     * @param CustomerDto the CustomerDto to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with String message, or with status {@code 400 (Bad Request)} if the customer must have an username.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/create-customer")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDto customerDto) throws URISyntaxException {
        log.debug("REST request to save Customer : {}", customerDto);
        if (customerDto.getUsername() != null) {
            throw new BadRequestAlertException("Please provide username");
        }
        String result = customerService.createCustomer(customerDto);
        return ResponseEntity.created(new URI("/api/create-customer/" + result))
            .body(result);
    }
    
    @GetMapping("/hello")
    public String test() {
    	return "hello";
    }

}
