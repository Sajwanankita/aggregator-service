package com.org.nagarro.nagp.orderdetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.nagarro.nagp.common.entity.OrderDetails;
import com.org.nagarro.nagp.order.service.OrderService;
import com.org.nagarro.nagp.orderdetails.service.OrderDetailsService;
import com.org.nagarro.nagp.user.service.UserService;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Service
public class OrderDetailsServiceServiceImpl implements OrderDetailsService {

	private OrderService orderService;
	private UserService userService;
	private Tracer tracer;

	@Autowired
	OrderDetailsServiceServiceImpl(OrderService orderService, UserService userService, Tracer tracer) {
		this.orderService = orderService;
		this.userService = userService;
		this.tracer = tracer;
	}

	@Override
	public OrderDetails getOrderDetailsByUserId(String userId, Span rootSpan) {
		Span span = tracer.buildSpan("Order Details Service : Get Order details by user id").asChildOf(rootSpan)
				.start();
		OrderDetails orderDetails = new OrderDetails(userService.getUserByUserId(userId, span),
				orderService.getOrdersByUserId(userId, span));
		span.setTag("http.status_code", 200);
		span.finish();
		return orderDetails;
	}

}
