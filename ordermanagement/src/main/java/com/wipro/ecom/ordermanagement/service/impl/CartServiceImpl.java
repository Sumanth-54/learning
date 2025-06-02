package com.wipro.ecom.ordermanagement.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ecom.ordermanagement.client.ProductClient;
import com.wipro.ecom.ordermanagement.entity.Cart;
import com.wipro.ecom.ordermanagement.exception.CartNotFoundException;
import com.wipro.ecom.ordermanagement.repo.CartRepository;
import com.wipro.ecom.ordermanagement.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductClient productClient;

    public CartServiceImpl(CartRepository cartRepository, ProductClient productClient) {
        this.cartRepository = cartRepository;
        this.productClient = productClient;
    }

    @Override
    @Transactional
    public Cart addProductToCart(int userId, int productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId).orElse(new Cart());
        if (cart.getProdDetails() == null) {
            cart.setProdDetails(new HashMap<>());
        }

        Map<Integer, Integer> prodDetails = cart.getProdDetails();

        int newQty = prodDetails.getOrDefault(productId, 0) + quantity;
        prodDetails.put(productId, newQty);

        cart.setUserId(userId);
        // Update totalQty and totalPrice as needed
        cart.setTotalQty(cart.getTotalQty() + quantity);
        // TODO: Calculate totalPrice from product prices via Product MS (optional here)

        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public Cart updateProductQuantity(int userId, int productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException("Cart not found for user: " + userId));

        Map<Integer, Integer> prodDetails = cart.getProdDetails();

        if (!prodDetails.containsKey(productId)) {
            throw new ResourceNotFoundException("Product not in cart");
        }

        int oldQty = prodDetails.get(productId);
        prodDetails.put(productId, quantity);
        cart.setTotalQty(cart.getTotalQty() - oldQty + quantity);

        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void removeProductFromCart(int userId, int productId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new CartNotFoundException("Cart not found for user: " + userId));

        Map<Integer, Integer> prodDetails = cart.getProdDetails();

        if (!prodDetails.containsKey(productId)) {
            throw new ResourceNotFoundException("Product not in cart");
        }

        int qtyRemoved = prodDetails.remove(productId);
        cart.setTotalQty(cart.getTotalQty() - qtyRemoved);

        cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> getCartByUserId(int userId) {
        return cartRepository.findByUserId(userId);
    }
}
