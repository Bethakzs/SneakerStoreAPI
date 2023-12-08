package org.example.controllers;

import org.example.models.Sneakers;
import org.example.models.User;
import org.example.services.CartService;
import org.example.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList(Pageable pageable) {
        Page<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users.getContent());
    }

    @GetMapping("/user/{id}/cart")
    public ResponseEntity<List<Sneakers>> getCartList(@PathVariable Long id) {
        List<Sneakers> cart = userService.getCart(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/user/{id}/cart")
    public ResponseEntity<Sneakers> addToCart(@PathVariable Long id, @RequestBody Sneakers sneakers) {
        Sneakers addedSneakers = userService.addToCart(id, sneakers);
        return ResponseEntity.ok(addedSneakers);
    }

//
//    @DeleteMapping("/cart/{id}")
//    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
//        userService.removeFromCart(id);
//        return ResponseEntity.ok().build();
//    }
}
