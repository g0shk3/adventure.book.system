package com.advance.academy.adventure.book.system.repository;

import com.advance.academy.adventure.book.system.model.adventure.Choice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Integer>, GetReference {


}
