package com.modulo23.entities;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modulo23.entities.Order;


@Entity
@Table(name = "tabela_usuario")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    @Column(name = "ID")
    private Integer id;

    @Column(name = "nome_cliente", nullable = false, length = 250)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 20)
    private String phone;

    @Column(name = "senha", nullable = false, length = 16)
    private String password;

    @JsonIgnore  //  Ignora a lista de pedidos do cliente
    @OneToMany(mappedBy = "client")  // 1 User pode ter varios Orders
    private List<Order> orders = new ArrayList<>();

    // ---------------------------------------   Constructors   --------------------------------------------------------

    public User() {}

    public User(Integer id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // ---------------------------------------   Getters and Setters   -------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // ---------------------------------------   HashCode and Equals   -------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
