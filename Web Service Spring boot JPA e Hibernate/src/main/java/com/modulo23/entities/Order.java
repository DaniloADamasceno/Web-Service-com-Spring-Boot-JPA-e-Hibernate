package com.modulo23.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.modulo23.entities.enuns.OrderStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedidos")
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

    @Column(name = "status_pedido")
    private Integer orderStatus;

    @ManyToOne()    //!  A Utilização do ManyToAny e melhor que o ManyToOne  --->> (metaColumn = @Column(name = "CLIENT_ID"))
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private User client;

    @OneToMany(mappedBy = "id.order")  //  Nome do atributo que está mapeando a tabela no outro lado da relação (OrderItem) --> usa-se o nome da Classe "(id.order)"
    private Set<OrderItem> items = new HashSet<>();


    //? ---------------------------------------   Constructors   --------------------------------------------------------

    public Order(Object o, Instant parse, User userNina) {}

    public Order(Integer id, Instant moment,OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;

    }

    public Order() {

    }
    // ---------------------------------------   Getters and Setters   -------------------------------------------------

    public Integer getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getOrderStatus() {
        if (orderStatus == null)
            return null;
        else
            return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public Set<OrderItem> getItems() {
        return items;
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
