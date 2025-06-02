package com.wipro.ecom.ordermanagement.controller;

import com.wipro.ecom.ordermanagement.entity.Order;
import com.wipro.ecom.ordermanagement.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(Authentication auth) {
        int userId = Integer.parseInt(auth.getName());
        Order order = orderService.placeOrder(userId);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> cancelOrder(@PathVariable int orderId, Authentication auth) {
        // Only allow if user owns order or ADMIN
        // Simplified check, implement fully in real app
        Order order = orderService.getOrderDetails(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")) &&
                order.getUserId() != Integer.parseInt(auth.getName())) {
            return ResponseEntity.status(403).build();
        }
        Order cancelledOrder = orderService.cancelOrder(orderId);
        return ResponseEntity.ok(cancelledOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(Authentication auth) {
        // Only ADMIN can get all orders
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable int userId, Authentication auth) {
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")) &&
                userId != Integer.parseInt(auth.getName())) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    @GetMapping("/orderDetails/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId, Authentication auth) {
        Order order = orderService.getOrderDetails(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")) &&
                order.getUserId() != Integer.parseInt(auth.getName())) {
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(order);
    }
}
