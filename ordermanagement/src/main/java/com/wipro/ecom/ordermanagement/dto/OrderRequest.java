package com.wipro.ecom.ordermanagement.dto;

import java.util.Map;

import jakarta.validation.constraints.NotNull;

public class OrderRequest {

	@NotNull
	private Integer userId;

	@NotNull
	private Map<Integer, Integer> productQuantityMap;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Map<Integer, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}

	public void setProductQuantityMap(Map<Integer, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}

}
