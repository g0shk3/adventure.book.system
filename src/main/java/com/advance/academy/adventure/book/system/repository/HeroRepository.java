package com.advance.academy.adventure.book.system.repository;


import com.advance.academy.adventure.book.system.model.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer>, GetReference{

    @Query("Select h FROM Hero h WHERE customer.id = :customerId")
    Optional<List<Hero>> getHeroByCustomerId(@Param("customerId") Integer customerId);

}
