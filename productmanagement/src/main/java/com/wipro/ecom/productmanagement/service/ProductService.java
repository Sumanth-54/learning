package com.wipro.ecom.productmanagement.service;

import java.util.List;

import com.wipro.ecom.productmanagement.entity.Product;

public interface ProductService {
	Product addProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(int id);

	List<Product> getAllProducts();

	Product getProductById(int id);
}
