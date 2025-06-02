package com.wipro.ecom.ordermanagement.entity;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;

	@ElementCollection
	private Map<Integer, Integer> prodDetails = new HashMap<>();

	private int totalQty;
	private double totalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Map<Integer, Integer> getProdDetails() {
		return prodDetails;
	}

	public void setProdDetails(Map<Integer, Integer> prodDetails) {
		this.prodDetails = prodDetails;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", prodDetails=" + prodDetails + ", totalQty=" + totalQty
				+ ", totalPrice=" + totalPrice + "]";
	}

}
