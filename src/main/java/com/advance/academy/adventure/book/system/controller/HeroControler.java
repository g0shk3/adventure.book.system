package com.advance.academy.adventure.book.system.controller;


import com.advance.academy.adventure.book.system.model.Hero;
import com.advance.academy.adventure.book.system.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hero")
public class HeroControler {

    private final HeroService heroService;


    @Autowired
    public HeroControler(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
     public Hero createOrUpdate(@RequestBody Hero hero){
        return heroService.createOrUpdate(hero);
    }


    @GetMapping(value ="list/customer/{customerId}")
    public List<Hero> getHeroList(@PathVariable("customerId") Integer customerId) {
        return heroService.getHeroByCustomerId(customerId);

    }

    @GetMapping(value = "/{heroId")
    public Hero getHero(@PathVariable("heroId") Integer heroId){
        return heroService.getHeroById(heroId);
    }

}
