package org.example.controllers;


import org.example.models.Sneakers;
import org.example.services.SneakerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SneakerController {
    private final SneakerService sneakerService;

    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Sneakers>> getAllMovies(Pageable pageable) {
        Page<Sneakers> moviePage = sneakerService.getAllSneakers(pageable);
        return ResponseEntity.ok(moviePage.getContent());
    }
}