package org.example.services;

import org.example.models.Sneakers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CartService {
    private final List<Sneakers> cart = new ArrayList<>();

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
