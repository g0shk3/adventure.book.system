package com.advance.academy.adventure.book.system.service;


import com.advance.academy.adventure.book.system.model.adventure.Step;
import com.advance.academy.adventure.book.system.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService {

    private final StepRepository stepRepository;

    @Autowired
    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public Step createOrUpdate(Step step){
        return stepRepository.save(step);
    }
}
