package com.modulo23.services;

import com.modulo23.entities.Order;
import com.modulo23.repositories.RepositoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  Anotação que indica que a classe é um serviço
public class ServiceOrder {

    @Autowired //  Injeção de dependência
    private RepositoryOrder repositoryOrder;


    //------------------------------------   Methods   -----------------------------------------------------------------

    public List<Order> findAll() {  //  Método que retorna todos os usuários
        return repositoryOrder.findAll();
    }

    public List<Order> findAllById(Integer id) {  //  Método que retorna todos os usuários através do ID
        Optional<Order> optionalById = repositoryOrder.findById(id);
        return (List<Order>) optionalById.get();
    }

}
