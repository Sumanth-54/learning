package com.wipro.ecom.productmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.ecom.productmanagement.entity.Product;
import com.wipro.ecom.productmanagement.exception.ProductNotFoundException;
import com.wipro.ecom.productmanagement.repo.ProductRepository;
import com.wipro.ecom.productmanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existing = repository.findById(product.getId())
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return repository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product existing = repository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        repository.delete(existing);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }
}
