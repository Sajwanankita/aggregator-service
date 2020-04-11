package com.org.nagarro.nagp.orderdetails.service;

import com.org.nagarro.nagp.common.entity.OrderDetails;

import io.opentracing.Span;

public interface OrderDetailsService {

	OrderDetails getOrderDetailsByUserId(String userId, Span rootSpan);

}
