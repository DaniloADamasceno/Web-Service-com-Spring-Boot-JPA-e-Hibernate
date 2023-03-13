package com.modulo23.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "pagamento")
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    private Integer id;

    private Instant moment;

    @JsonIgnore
    @OneToOne  // 1 pagamento para 1 pedido
    @MapsId // para o id do pagamento ser o mesmo do pedido
    private Order order;

    //?--------------------------------------   Constructors   ---------------------------------------------------------
    public Payment() {
    }
    public Payment(Integer id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }
    //?--------------------------------------   Getters and Setters   --------------------------------------------------

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //?--------------------------------------   HashCode and Equals   --------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Objects.equals(getId(), payment.getId()) && Objects.equals(getMoment(), payment.getMoment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoment());
    }
}
