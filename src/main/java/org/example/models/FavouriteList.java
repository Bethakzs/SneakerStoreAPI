package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class FavouriteList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Sneakers> sneakers;

    public FavouriteList() {
    }

    public FavouriteList(List<Sneakers> sneakers) {
        this.sneakers = sneakers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sneakers> getSneakers() {
        return sneakers;
    }

    public void setSneakers(List<Sneakers> sneakers) {
        this.sneakers = sneakers;
    }
}
