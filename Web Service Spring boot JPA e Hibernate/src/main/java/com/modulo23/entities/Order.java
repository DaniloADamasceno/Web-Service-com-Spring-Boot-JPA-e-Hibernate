package com.modulo23.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;

@Entity
@Table(name = "tabela_pedidos")
public class Order implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    @Column(name = "id_pedido")
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")  //  Formatação da data e hora
    @Column(name = "hora_pedido")
    private Instant moment;               //!  A Utilização do INSTANT e melhor que o Date

    @ManyToOne()    //!  A Utilização do ManyToAny e melhor que o ManyToOne  --->> (metaColumn = @Column(name = "CLIENT_ID"))
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private User client;

    // ---------------------------------------   Constructors   --------------------------------------------------------

    public Order() {}

    public Order(Integer id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
    }
    // ---------------------------------------   Getters and Setters   -------------------------------------------------

    public Integer getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
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