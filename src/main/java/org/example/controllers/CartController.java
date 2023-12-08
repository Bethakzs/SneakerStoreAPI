package org.example.controllers;

import org.example.models.Sneakers;
import org.example.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Sneakers>> getCartList() {
        List<Sneakers> cart = cartService.getCart();
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<List<Sneakers>> getCartList(@PathVariable String id) {
        List<Sneakers> cart = cartService.getCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/cart")
    public ResponseEntity<Sneakers> addToCart(@RequestBody Sneakers sneakers) {
        Sneakers addedSneakers = cartService.addToCart(sneakers);
        return ResponseEntity.ok(addedSneakers);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cart/all")
    public ResponseEntity<Void> removeAllFromCart() {
        cartService.removeAllFromCart();
        return ResponseEntity.ok().build();
    }
}
