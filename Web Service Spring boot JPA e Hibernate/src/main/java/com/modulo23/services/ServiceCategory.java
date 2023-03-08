package com.modulo23.services;

import com.modulo23.entities.Category;
import com.modulo23.repositories.RepositoryCategry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //  Anotação que indica que a classe é um serviço
public class ServiceCategory {

    @Autowired //  Injeção de dependência
    private RepositoryCategry repositoryCategory;


    //------------------------------------   Methods   -----------------------------------------------------------------

    public List<Category> findAll() {  //  Método que retorna todos os usuários
        return repositoryCategory.findAll();
    }

    public List<Category> findAllById(Integer id) {  //  Método que retorna todos os usuários através do ID
        Optional<Category> optionalById = repositoryCategory.findById(id);
        return (List<Category>) optionalById.get();
    }

}
