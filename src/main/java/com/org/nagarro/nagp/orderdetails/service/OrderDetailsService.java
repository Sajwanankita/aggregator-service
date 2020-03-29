package com.org.nagarro.nagp.orderdetails.service;

import com.org.nagarro.nagp.common.entity.OrderDetails;

public interface OrderDetailsService {

	OrderDetails getOrderDetailsByUserId(String userId);

}
