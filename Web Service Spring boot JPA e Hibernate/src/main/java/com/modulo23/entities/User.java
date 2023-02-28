package com.modulo23.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.io.Serializable;

@Entity
@Table(name = "table_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String password;

    // ---------------------------------------   Constructors   --------------------------------------------------------

    public User() {}

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // ---------------------------------------   Getters and Setters   -------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
