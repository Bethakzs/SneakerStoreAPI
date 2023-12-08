package org.example.services;

import org.example.models.Sneakers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    @Service
    public class FavouriteListService {
        private final List<Sneakers> favouriteList = new ArrayList<>();

        public List<Sneakers> getFavouriteList() {
            return favouriteList;
        }

        public Sneakers addToFavouriteList(Sneakers sneakers) {
            favouriteList.add(sneakers);
            return sneakers;
        }

        public void removeFromFavouriteList(Long id) {
            favouriteList.removeIf(sneakers -> Objects.equals(sneakers.getId(), id));
        }
    }

