package com.advance.academy.adventure.book.system.model;

import com.advance.academy.adventure.book.system.model.adventure.Adventure;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "value", unique = true)
    private String value;

    @ManyToMany(mappedBy =  "tags")
    private Set<Adventure> adventures = new HashSet<>();

    public Integer getId() {
        return id;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Adventure> getAdventures() {
        return adventures;
    }

    public void setAdventures(Set<Adventure> adventures) {
        this.adventures = adventures;
    }


}
