package com.advance.academy.adventure.book.system.model;

import com.advance.academy.adventure.book.system.model.adventure.Choice;
import com.advance.academy.adventure.book.system.model.adventure.Step;

import javax.persistence.*;

@Entity
@Table(name ="adventure_progress_historyes")
public class AdventureProgressHistory {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @ManyToOne
    @JoinColumn(name = "choise_id")
    private Choice choise;

    public Integer getId() {
        return id;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Choice getChoise() {
        return choise;
    }

    public void setChoise(Choice choise) {
        this.choise = choise;
    }
}
