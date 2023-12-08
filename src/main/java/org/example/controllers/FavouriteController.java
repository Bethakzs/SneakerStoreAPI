package org.example.controllers;

import org.example.models.Sneakers;
import org.example.services.FavouriteListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FavouriteController {
    private final FavouriteListService favouriteListService;

    public FavouriteController(FavouriteListService favouriteListService) {
        this.favouriteListService = favouriteListService;
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Sneakers>> getFavouriteList() {
        List<Sneakers> favouriteList = favouriteListService.getFavouriteList();
        return ResponseEntity.ok(favouriteList);
    }

    @PostMapping("/favorites")
    public ResponseEntity<Sneakers> addToFavouriteList(@RequestBody Sneakers sneakers) {
        Sneakers addedSneakers = favouriteListService.addToFavouriteList(sneakers);
        return ResponseEntity.ok(addedSneakers);
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<Void> removeFromFavouriteList(@PathVariable Long id) {
        favouriteListService.removeFromFavouriteList(id);
        return ResponseEntity.ok().build();
    }
}