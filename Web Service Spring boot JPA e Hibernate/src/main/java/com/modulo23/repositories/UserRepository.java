package com.modulo23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modulo23.entities.User;
import org.springframework.stereotype.Repository;

@Repository //  Anotação que indica que a classe é um repositório
public interface UserRepository extends JpaRepository<User, Integer> {

}
