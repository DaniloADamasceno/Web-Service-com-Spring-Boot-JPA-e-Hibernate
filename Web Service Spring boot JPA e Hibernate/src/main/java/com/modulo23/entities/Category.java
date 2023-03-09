package com.modulo23.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_categoria")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;


    @JsonIgnore  // para não entrar em ‘loop’ infinito na serialização
    @ManyToMany(mappedBy = "categories") //nome do atributo que está mapeando a tabela no outro lado da relação (Product) --> usa-se o nome da Coleção "(categories)"
    private Set<Product> products = new HashSet<>();
    //---------------------------------------   Constructors   ---------------------------------------------------------
    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
//---------------------------------------   Getters and Setters   --------------------------------------------------

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

    public Set<Product> getProducts() {
        return products;
    }

    //---------------------------------------   HashCode and Equals   --------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getId().equals(category.getId()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
