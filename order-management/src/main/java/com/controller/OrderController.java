package com.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.OrderDto;
import com.exception.BadRequestAlertException;
import com.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	 private final Logger log = LoggerFactory.getLogger(OrderController.class);


	@Autowired
	OrderService orderService;
	
	
	 /**
     * {@code POST  /create-order} : Create a new order.
     *
     * @param CustomerDto the CustomerDto to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with String message, or with status {@code 400 (Bad Request)} if the customer must have an username.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/create-order")
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) throws URISyntaxException {
        log.debug("REST request to save Order : {}", orderDto);
        if (orderDto.getCustomerDto().getUsername() != null) {
            throw new BadRequestAlertException("Please provide username");
        }
        OrderDto result = orderService.saveOrder(orderDto);
        return ResponseEntity.created(new URI("/api/create-customer/" + result))
            .body(result);
    }
}
