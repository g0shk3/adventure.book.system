package com.advance.academy.adventure.book.system.repository;

import com.advance.academy.adventure.book.system.model.adventure.Step;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends CrudRepository <Step, Integer>,GetReference {

}
