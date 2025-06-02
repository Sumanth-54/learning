package com.wipro.ecom.ordermanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.ordermanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(int userId);
}
