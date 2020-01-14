package com.advance.academy.adventure.book.system.model;

import com.advance.academy.adventure.book.system.model.Customer;
import com.advance.academy.adventure.book.system.model.adventure.Adventure;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "current_repotation")
    private Integer curentRepotation;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "adventure_id")
    private Adventure adventure;

    @Column(name = "number_off_lives")
    private Integer numberOffLives;


    public Integer getId() {
        return id;
    }

    public Integer getNumberOffLives() {
        return numberOffLives;
    }

    public void setNumberOffLives(Integer numberOffLives) {
        this.numberOffLives = numberOffLives;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getCurentRepotation() {
        return curentRepotation;
    }

    public void setCurentRepotation(Integer curentRepotation) {
        this.curentRepotation = curentRepotation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }
}
