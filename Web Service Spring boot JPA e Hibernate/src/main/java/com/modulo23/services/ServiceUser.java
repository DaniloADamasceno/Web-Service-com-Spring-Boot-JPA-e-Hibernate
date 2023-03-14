package com.modulo23.services;

import com.modulo23.entities.User;
import com.modulo23.repositories.RepositoryUser;
import com.modulo23.services.exceptions.ResourceNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // -->  Anotação que indica que a classe é um serviço
public class ServiceUser {

    @Autowired // -->  Injeção de dependência
    private RepositoryUser repositoryUser;


    //?-----------------------------------   Methods   -----------------------------------------------------------------

    public List<User> findAll() {  // -->  Método que retorna todos os usuários
        return repositoryUser.findAll();
    }

    public User findAllById(Integer id) { // -->  Método que retorna todos os usuários através do ID
        Optional<User> optionalById = repositoryUser.findById(id);
        return optionalById.orElseThrow(() -> new ResourceNotFoudException(id));
    }

    public User insert(User userInsert) {
        return repositoryUser.save(userInsert);
    }

    public void delete(Integer id) { // -->  Método que deleta um usuário
        repositoryUser.deleteById(id);
    }

    public User update(Integer id, User userUpdate) {
        User updateUser = repositoryUser.getReferenceById(id);
        updateData(updateUser, userUpdate);
        return repositoryUser.save(updateUser);
    }

    //? -----------------------------------   Private Methods   --------------------------------------------------------
    private void updateData(User updateUser, User userUpdate) {
        updateUser.setName(userUpdate.getName());         // -->  Atualiza o nome do usuário
        updateUser.setEmail(userUpdate.getEmail());       // -->  Atualiza o email do usuário
        updateUser.setPhone(userUpdate.getPhone());       // -->  Atualiza o telefone do usuário
    }
}
