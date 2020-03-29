package com.org.nagarro.nagp.common.entity;

import com.org.nagarro.nagp.common.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private String orderId;
	private int orderAmount;
	private String orderDate;
}
