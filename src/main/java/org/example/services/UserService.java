package org.example.services;

import org.example.models.Sneakers;
import org.example.models.User;
import org.example.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<Sneakers> getCart() {
        return cart;
    }

    public Sneakers addToCart(Sneakers sneakers) {
        cart.add(sneakers);
        return sneakers;
    }

    public void removeFromCart(Long id) {
        cart.removeIf(sneakers -> Objects.equals(sneakers.getId(), id));
    }

    public void removeAllFromCart() {
        cart.clear();
    }
}
