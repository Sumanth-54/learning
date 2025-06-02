package com.wipro.ecom.productmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.productmanagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
