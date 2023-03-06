package com.modulo23.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;

public class Order implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Instant moment;               //!  A Utilização do INSTANT e melhor que o Date

    private User client;

    // ---------------------------------------   Constructors   --------------------------------------------------------

    public Order() {}

    public Order(Integer id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    // ---------------------------------------   Getters and Setters   -------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    //---------------------------------------   HashCode and Equals   --------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId().equals(order.getId()) && getMoment().equals(order.getMoment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoment());
    }

    //---------------------------------------   ToString   -------------------------------------------------------------

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                '}';
    }
    //---------------------------------------   Methods   --------------------------------------------------------------

    private Double total() {
        return null;
    }
}
