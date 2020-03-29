package com.org.nagarro.nagp.orderdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.nagarro.nagp.common.entity.OrderDetails;
import com.org.nagarro.nagp.orderdetails.service.OrderDetailsService;

@RestController
@RequestMapping(value = "orderdetails")
public class OrderDetailsController {

	OrderDetailsService orderDetailsService;

	@Autowired
	public OrderDetailsController(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}

	@GetMapping(value = "/{userId}")
	public OrderDetails getOrderDetailsByUserId(@PathVariable(value = "userId") String userId) {
		return orderDetailsService.getOrderDetailsByUserId(userId);
	}
}
