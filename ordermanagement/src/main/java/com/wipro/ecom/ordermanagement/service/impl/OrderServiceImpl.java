package com.wipro.ecom.ordermanagement.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ecom.ordermanagement.client.ProductClient;
import com.wipro.ecom.ordermanagement.entity.Cart;
import com.wipro.ecom.ordermanagement.entity.Order;
import com.wipro.ecom.ordermanagement.exception.OrderNotFoundException;
import com.wipro.ecom.ordermanagement.repo.CartRepository;
import com.wipro.ecom.ordermanagement.repo.OrderRepository;
import com.wipro.ecom.ordermanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.productClient = productClient;
    }

    @Override
    @Transactional
    public Order placeOrder(int userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user: " + userId));

        // Call Product MS to update quantities (reduce stock)
        cart.getProdDetails().forEach((productId, qty) -> {
            productClient.updateProductQuantity(productId, -qty);
        });

        Order order = new Order();
        order.setUserId(userId);
        order.setProductQuantityMap(cart.getProdDetails());
        order.setTotalAmount(cart.getTotalPrice());
        order.setOrderStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        // Clear the cart
        cart.setProdDetails(null);
        cart.setTotalQty(0);
        cart.setTotalPrice(0);
        cartRepository.save(cart);

        return savedOrder;
    }

    @Override
    @Transactional
    public Order cancelOrder(int orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + orderId));

        if ("CANCELLED".equalsIgnoreCase(order.getOrderStatus())) {
            throw new IllegalStateException("Order already cancelled");
        }

        // Update product quantities (increase stock)
        order.getProductQuantityMap().forEach((productId, qty) -> {
            productClient.updateProductQuantity(productId, qty);
        });

        order.setOrderStatus("CANCELLED");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Optional<Order> getOrderDetails(int orderId) {
        return orderRepository.findById(orderId);
    }
}
