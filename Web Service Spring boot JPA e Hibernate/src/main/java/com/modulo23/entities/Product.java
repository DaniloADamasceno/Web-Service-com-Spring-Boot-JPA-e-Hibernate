package com.modulo23.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.modulo23.entities.Category;

@Entity
@Table(name = "produto")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_produto")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "descricao")
    private String description;

    @Column(name = "preço")
    private Double price;

    @Column(name = "url_imagem")
    private String urlImage;

    //@Transient   //quando não quer que o atributo seja persistido no banco de dados
    @ManyToMany
    @JoinTable(name = "produto_categoria",          //nome da tabela que vai ser criada no banco de dados
            joinColumns = @JoinColumn(name = "id_produto"),  //Nome da Tabela que está sendo mapeada
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Category> categories = new HashSet<>();
    //---------------------------------------   Constructors   ---------------------------------------------------------

    public Product() {}

    public Product(Integer id, String name, String description, Double price, String urlImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.urlImage = urlImage;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    //---------------------------------------   HashCode and Equals   --------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
