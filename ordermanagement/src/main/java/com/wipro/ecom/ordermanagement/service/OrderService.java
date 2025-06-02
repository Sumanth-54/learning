package com.wipro.ecom.ordermanagement.service;

import com.wipro.ecom.ordermanagement.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order placeOrder(int userId);

    Order cancelOrder(int orderId);

    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(int userId);

    Optional<Order> getOrderDetails(int orderId);

}
