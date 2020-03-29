package com.org.nagarro.nagp.orderdetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.nagarro.nagp.common.entity.OrderDetails;
import com.org.nagarro.nagp.order.service.OrderService;
import com.org.nagarro.nagp.orderdetails.service.OrderDetailsService;
import com.org.nagarro.nagp.user.service.UserService;

@Service
public class OrderServiceServiceImpl implements OrderDetailsService {

	OrderService orderService;
	UserService userService;

	@Autowired
	OrderServiceServiceImpl(OrderService orderService, UserService userService) {
		this.orderService = orderService;
		this.userService = userService;
	}

	@Override
	public OrderDetails getOrderDetailsByUserId(String userId) {
		return new OrderDetails(userService.getUserByUserId(userId), orderService.getOrderDetailsByUserId(userId));
	}

}
