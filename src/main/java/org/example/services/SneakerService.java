package org.example.services;

import org.example.models.Sneakers;
import org.example.repo.SneakerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SneakerService {
    private final SneakerRepository sneakerRepository;

    public SneakerService(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }

    public Page<Sneakers> getAllSneakers(Pageable pageable) {
        return sneakerRepository.findAll(pageable);
    }

    public void removeFromCart(Long id) {
        sneakerRepository.deleteById(id);
    }

    public Sneakers addToCart(Sneakers sneakers) {
        return sneakerRepository.save(sneakers);
    }
}
