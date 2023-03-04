package com.modulo23.entities;


import lombok.Getter;
import jakarta.persistence.*;


import java.io.Serializable;


@Getter
@Entity
@Table(name = "table_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Nome")
    private String name;

    //@Column(email = "Email")
    private String email;

    //@Column(phone = "Telefone")
    private String phone;

    //@Column(password = "Senha")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
