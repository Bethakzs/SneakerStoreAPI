package org.example.controllers;

import org.example.models.Cart;
import org.example.models.FavouriteList;
import org.example.models.Sneakers;
import org.example.models.User;
import org.example.services.CartService;
import org.example.services.FavouriteListService;
import org.example.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    private final UserService userService;
    private final CartService cartService;
    private final FavouriteListService favouriteListService;

    public UserController(UserService userService, CartService cartService, FavouriteListService favouriteListService) {
        this.userService = userService;
        this.cartService = cartService;
        this.favouriteListService = favouriteListService;
    }
//User
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList(Pageable pageable) {
        Page<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users.getContent());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<Void> removeUser(@PathVariable Long id) {
//        userService.removeUser(id);
//        return ResponseEntity.ok().build();
//    }
//Cart
    @GetMapping("/user/{id}/cart")
    public ResponseEntity<Optional<Cart>> getCartList(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCart(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/user/{id}/cart")
    public ResponseEntity<Sneakers> addToCart(@PathVariable Long id, @RequestBody Sneakers sneakers) {
        Sneakers addedSneakers = cartService.addToCart(id, sneakers);
        return ResponseEntity.ok(addedSneakers);
    }

    @DeleteMapping("/user/{id}/cart")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id, @RequestBody Sneakers sneakers) {
        cartService.removeFromCart(id, sneakers);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{id}/cart-all")
    public ResponseEntity<Void> removeAllFromCart(@PathVariable Long id) {
        cartService.removeAllFromCart(id);
        return ResponseEntity.ok().build();
    }
//favouriteList
    @GetMapping("/user/{id}/favorites")
    public ResponseEntity<Optional<FavouriteList>> getFavouriteList(@PathVariable Long id) {
        Optional<FavouriteList> favouriteList = favouriteListService.getFavouriteList(id);
        return ResponseEntity.ok(favouriteList);
    }

    @PostMapping("/user/{id}/favorites")
    public ResponseEntity<Sneakers> addToFavouriteList(@PathVariable Long id, @RequestBody Sneakers sneakers) {
        Sneakers addedSneakers = favouriteListService.addToFavouriteList(id, sneakers);
        return ResponseEntity.ok(addedSneakers);
    }

    @DeleteMapping("/user/{id}/favorites")
    public ResponseEntity<Void> removeFromFavouriteList(@PathVariable Long id, @RequestBody Sneakers sneakers) {
        favouriteListService.removeFromCart(id, sneakers);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{id}/favorites-all")
    public ResponseEntity<Void> removeAllFromFavouriteList(@PathVariable Long id) {
        favouriteListService.removeAllFromCart(id);
        return ResponseEntity.ok().build();
    }
}
