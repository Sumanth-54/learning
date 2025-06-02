package com.wipro.ecom.ordermanagement.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private int userId;

	@ElementCollection
	private Map<Integer, Integer> productQuantityMap = new HashMap<>();

	private double totalAmount;
	private String orderStatus;
	private LocalDateTime orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Map<Integer, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}

	public void setProductQuantityMap(Map<Integer, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", productQuantityMap=" + productQuantityMap
				+ ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}

}
