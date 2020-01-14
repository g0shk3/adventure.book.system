package com.advance.academy.adventure.book.system.model.adventure;

import com.advance.academy.adventure.book.system.model.Tag;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "adventures")
public class Adventure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "story")
    private String story;

    @OneToOne(cascade = {CascadeType.ALL},fetch =  FetchType.LAZY)
    @JoinColumn(name = "first_step_id")
    private Step firstStep;

    @Column(name = "number_of_lifes")
    private Integer numberOfLifes;

    @Column(name = "starting_repotation")
    private Integer startingRepotation;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "adventure_tags",
            joinColumns = { @JoinColumn(name = "adventure_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> tags = new HashSet<>();


    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Step getFirstStep() {
        return firstStep;
    }

    public void setFirstStep(Step firstStep) {
        this.firstStep = firstStep;
    }

    public Integer getNumberOfLifes() {
        return numberOfLifes;
    }

    public void setNumberOfLifes(Integer numberOfLifes) {
        this.numberOfLifes = numberOfLifes;
    }

    public Integer getStartingRepotation() {
        return startingRepotation;
    }

    public void setStartingRepotation(Integer startingRepotation) {
        this.startingRepotation = startingRepotation;
    }
}
