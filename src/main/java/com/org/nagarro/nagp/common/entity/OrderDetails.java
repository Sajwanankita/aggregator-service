package com.org.nagarro.nagp.common.entity; 

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

	private User user;
	private List<Order> orders;

}
