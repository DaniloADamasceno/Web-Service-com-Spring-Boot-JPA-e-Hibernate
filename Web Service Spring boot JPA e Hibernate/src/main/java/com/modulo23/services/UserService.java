package com.modulo23.services;

import com.modulo23.entities.User;
import com.modulo23.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class UserService  {

    @Autowired
    private UserRepository repository;

    //------------------------------------   Methods   -----------------------------------------------------------------

    public List<User> findAll() {  //  Método que retorna todos os usuários
        return repository.findAll();
    }

    public List<User> findAllById(Long id) {  //  Método que retorna todos os usuários através do ID
        return repository.findAllById(Collections.singleton(id));
    }

}
