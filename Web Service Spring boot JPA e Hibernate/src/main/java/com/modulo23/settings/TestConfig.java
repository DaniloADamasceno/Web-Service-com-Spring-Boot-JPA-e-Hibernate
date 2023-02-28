package com.modulo23.settings;

import com.modulo23.repositories.UserRepository;
import com.modulo23.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //  Anotação que indica que a classe e de Configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired//  Injeção de dependência
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception { // Método que será executado quando a aplicação for iniciada

        //  Criação de um usuário para teste
        User userNina = new User(null, "Nina", "nina@gmail.com","61922223333", "2222");
        User userFred = new User(null, "Frederico", "frederico@gmail.com","61933334444", "3333");

        //  Salvando o usuário no banco de dados
        userRepository.saveAll(Arrays.asList(userNina, userFred));

       // userRepository.save(userFred);  --- >>>     Salvando o usuário no banco de dados (Outra forma)

    }
}
