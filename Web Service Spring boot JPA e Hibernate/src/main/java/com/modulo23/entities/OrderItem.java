package com.modulo23.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modulo23.entities.primaryKeys.PrimaryKeyOrderItem;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double price;

    @EmbeddedId //para dizer que a classe é um subtipo de outra classe
    private PrimaryKeyOrderItem id = new PrimaryKeyOrderItem();

    //?--------------------------------------   Constructors   ---------------------------------------------------------


    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {

    }

    //?--------------------------------------   Getters and Setters   --------------------------------------------------

    @JsonIgnore // para não entrar em ‘loop’ infinito na serialização
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //?--------------------------------------   HashCode and Equals   --------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return getQuantity().equals(orderItem.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity());
    }

    //?--------------------------------------   Methods   --------------------------------------------------------------
    public Double subTotal() {
        return price * quantity;
    }

}
