package com.wipro.ecom.ordermanagement.controller;

import com.wipro.ecom.ordermanagement.entity.Cart;
import com.wipro.ecom.ordermanagement.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addProd")
    public ResponseEntity<Cart> addProductToCart(@RequestParam int productId, @RequestParam int quantity, Authentication auth) {
        int userId = Integer.parseInt(auth.getName());
        Cart cart = cartService.addProductToCart(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/deleteProd/{itemid}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable("itemid") int productId, Authentication auth) {
        int userId = Integer.parseInt(auth.getName());
        cartService.removeProductFromCart(userId, productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Cart> updateProductQuantity(@RequestParam int productId, @RequestParam int quantity, Authentication auth) {
        int userId = Integer.parseInt(auth.getName());
        Cart updatedCart = cartService.updateProductQuantity(userId, productId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable int userId, Authentication auth) {
        // Allow user to get their own cart or ADMIN to get any
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")) && userId != Integer.parseInt(auth.getName())) {
            return ResponseEntity.status(403).build();
        }
        return cartService.getCartByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
