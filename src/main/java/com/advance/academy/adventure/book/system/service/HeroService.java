package com.advance.academy.adventure.book.system.service;


import com.advance.academy.adventure.book.system.model.Hero;
import com.advance.academy.adventure.book.system.model.adventure.Adventure;
import com.advance.academy.adventure.book.system.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero createOrUpdate(Hero hero){
        hero.setCurentRepotation(heroRepository.getReference(Adventure.class , hero.getAdventure().getId()).getStartingRepotation());
        hero.setNumberOffLives(heroRepository.getReference(Adventure.class ,hero.getAdventure().getId()).getNumberOfLifes());
       return heroRepository.save(hero);

    }

    public List<Hero> getHeroByCustomerId(Integer customerId){
        List<Hero>heroList = new ArrayList<>();
        Optional<List<Hero>> result = heroRepository.getHeroByCustomerId(customerId);
           if (result.isPresent()){
               heroList.addAll(result.get());
           }
           return  heroList;
    }

    public Hero getHeroById(Integer heroId){
        Hero hero = null;
        Optional<Hero> result = heroRepository.findById(heroId);
        if (result.isPresent()){
           hero = result.get();
        }

        return  hero;
    }
}

