    package org.example.repo;

    import org.example.models.Sneakers;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface SneakerRepository extends CrudRepository<Sneakers, Long> {
        Page<Sneakers> findAll(Pageable pageable);
    }
