package com.modulo23.services;

import com.modulo23.entities.User;
import com.modulo23.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  Anotação que indica que a classe é um serviço
public class ServiceUser {

    @Autowired //  Injeção de dependência
    private RepositoryUser repository;


    //------------------------------------   Methods   -----------------------------------------------------------------

    public List<User> findAll() {  //  Método que retorna todos os usuários
        return repository.findAll();
    }

    public List<User> findAllById(Integer id) {  //  Método que retorna todos os usuários através do ID
        Optional<User> optionalById = repository.findById(id);
        return (List<User>) optionalById.get();
    }

}
