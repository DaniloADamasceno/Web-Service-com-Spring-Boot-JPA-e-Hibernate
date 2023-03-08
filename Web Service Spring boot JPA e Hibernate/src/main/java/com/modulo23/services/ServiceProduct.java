package com.modulo23.services;

import com.modulo23.entities.Product;
import com.modulo23.repositories.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  Anotação que indica que a classe é um serviço
public class ServiceProduct {

    @Autowired //  Injeção de dependência
    private RepositoryProduct repositoryProduct;


    //------------------------------------   Methods   -----------------------------------------------------------------

    public List<Product> findAll() {  //  Método que retorna todos os usuários
        return repositoryProduct.findAll();
    }

    public List<Product> findAllById(Integer id) {  //  Método que retorna todos os usuários através do ID
        Optional<Product> optionalById = repositoryProduct.findById(id);
        return (List<Product>) optionalById.get();
    }

}
