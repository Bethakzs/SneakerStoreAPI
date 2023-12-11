package org.example.repo;

import org.example.models.FavouriteList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteListRepository extends CrudRepository<FavouriteList, Long> {
    Page<FavouriteList> findAll(Pageable pageable);
}

