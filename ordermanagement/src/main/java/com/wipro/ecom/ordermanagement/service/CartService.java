package com.wipro.ecom.ordermanagement.service;

import com.wipro.ecom.ordermanagement.entity.Cart;

import java.util.Optional;

public interface CartService {

    Cart addProductToCart(int userId, int productId, int quantity);

    Cart updateProductQuantity(int userId, int productId, int quantity);

    void removeProductFromCart(int userId, int productId);

    Optional<Cart> getCartByUserId(int userId);

}
