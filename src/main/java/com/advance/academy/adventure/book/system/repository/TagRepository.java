package com.advance.academy.adventure.book.system.repository;

import com.advance.academy.adventure.book.system.model.Tag;
import com.advance.academy.adventure.book.system.model.adventure.Adventure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>, GetReference {

    @Query("SELECT t FROM Tag t WHERE :adventure IN(adventures)")
    Optional<List<Tag>> findAllByAdventure(@Param("adventure") Adventure adventure);
}
