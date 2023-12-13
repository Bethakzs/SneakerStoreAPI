package org.example.services;

import org.example.models.Cart;
import org.example.models.FavouriteList;
import org.example.models.Sneakers;
import org.example.repo.FavouriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FavouriteListService {

    @Autowired
    private final FavouriteListRepository favouriteListRepository;

    public FavouriteListService(FavouriteListRepository favouriteListRepository) {
        this.favouriteListRepository = favouriteListRepository;
    }

    public Optional<FavouriteList> getFavouriteList(Long id) {
        return favouriteListRepository.findById(id);
    }

    public Sneakers addToFavouriteList(Long id, Sneakers sneakers) {
        Optional<FavouriteList> favouriteListOptional = getFavouriteList(id);
        if (favouriteListOptional.isPresent()) {
            FavouriteList favouriteList = favouriteListOptional.get();
            favouriteList.getSneakers().add(sneakers);
            favouriteListRepository.save(favouriteList);
            return sneakers;
        }
        return null;
    }

    public boolean removeFromFavouriteList(Long id, Long sneakerId) {
        Optional<FavouriteList> favouriteListOptional = getFavouriteList(id);
        if (favouriteListOptional.isEmpty()) {
            return false;
        }
        FavouriteList favouriteList = favouriteListOptional.get();
        favouriteList.getSneakers().removeIf(sneaker -> sneaker.getId() == sneakerId);
        favouriteListRepository.save(favouriteList);
        return true;
    }

    public void removeAllFromCart(Long id) {
        Optional<FavouriteList> favouriteListOptional = getFavouriteList(id);
        if (favouriteListOptional.isPresent()) {
            FavouriteList favouriteList = favouriteListOptional.get();
            favouriteList.getSneakers().clear();
            favouriteListRepository.save(favouriteList);
        }
    }
}

