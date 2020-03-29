package com.org.nagarro.nagp.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.org.nagarro.nagp.common.entity.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Value("${order.service.url}")
	private String orderServiceUrl;

	@Autowired
	RestTemplate restTemplate;

	public List<Order> getOrderDetailsByUserId(String userId) {
		List<Order> response = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromUriString(orderServiceUrl + "/orders/" + userId);

		ResponseEntity<List<Order>> responseEntity = restTemplate.exchange(uriComponentsBuilder.toUriString(),
				HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), new ParameterizedTypeReference<List<Order>>() {
				});
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			log.info("Request for response to order-service is successful.");
			response = responseEntity.getBody();
		} else {
			log.error("There was a problem with requesting response from order-service.");
		}
		return response;
	}
}
