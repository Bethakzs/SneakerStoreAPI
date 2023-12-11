package org.example.repo;

import org.example.models.Sneakers;
import org.example.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    List<User> findByCartId(Long id);

//    Optional<User> delete(Optional<User> user);
}

