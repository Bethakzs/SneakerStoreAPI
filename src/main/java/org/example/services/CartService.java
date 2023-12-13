package org.example.services;

import org.example.models.Cart;
import org.example.models.Sneakers;
import org.example.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> getCart(Long id) {
        return cartRepository.findById(id);
    }

    public Sneakers addToCart(Long id, Sneakers sneakers) {
        Optional<Cart> cartOptional = getCart(id);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.getSneakers().add(sneakers);
            cartRepository.save(cart);
            return sneakers;
        }
        return null;
    }

    public boolean removeFromCart(Long id, Long sneakerId) {
        Optional<Cart> cartOptional = getCart(id);
        if (cartOptional.isEmpty()) {
            return false;
        }
        Cart cart = cartOptional.get();
        cart.getSneakers().removeIf(sneaker -> sneaker.getId() == sneakerId);
        cartRepository.save(cart);
        return true;
    }

    public void removeAllFromCart(Long id) {
        Optional<Cart> cartOptional = getCart(id);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.getSneakers().clear();
            cartRepository.save(cart);
        }
    }
}
