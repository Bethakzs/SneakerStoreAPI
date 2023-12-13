package org.example.controllers;


import org.example.models.Sneakers;
import org.example.services.SneakerService;
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

    //Code of C++ Developer Nazar
    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Sneakers>> getSneakerById(@PathVariable Long id){
        return ResponseEntity.ok(sneakerService.findById(id));
    }
}