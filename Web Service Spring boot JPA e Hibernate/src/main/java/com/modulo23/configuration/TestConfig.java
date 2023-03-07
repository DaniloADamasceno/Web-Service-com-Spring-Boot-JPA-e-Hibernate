package com.modulo23.configuration;

import com.modulo23.entities.Order;
import com.modulo23.entities.User;
import com.modulo23.repositories.RepositoryOrder;
import com.modulo23.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //  Anotação que indica que a classe e de Configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired//  Injeção de dependência
    private RepositoryUser userRepository;

    @Autowired
    private RepositoryOrder orderRepository;

    @Override
    public void run(String... args) throws Exception { // Método que será executado quando a aplicação for iniciada

        //------------------------   Criação de uns usuários para teste   ----------------------------------------------
        User userNina = new User(null, "Nina", "nina@gmail.com","6191112222", "1111");
        User userFred = new User(null, "Frederico", "frederico@gmail.com","6192223333", "2222");
        User userSnow = new User(null, "Snow", "snow@gmail.com","6191114444", "3333");
        User userMaggie = new User(null, "Maggie", "maggie@gmail.com","6194445555", "4444");
        User userSnoopy = new User(null, "Snoopy", "snoopy@gmail.com","6195556666", "5555");
        User userMalu = new User(null, "Malu", "malu@gmail.com","6196667777", "6666");

        //-------------------------   Criação de alguns pedidos para teste   -------------------------------------------
        Order orderNina = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), userNina);
        Order order2Nina = new Order(null, Instant.parse("2021-06-18T19:53:07Z"), userNina);
        Order orderFred = new Order(null, Instant.parse("2021-07-21T03:42:10Z"), userFred);
        Order orderSnow = new Order(null, Instant.parse("2021-08-22T15:21:22Z"), userSnow);
        Order orderMaggie = new Order(null, Instant.parse("2021-09-23T09:10:55Z"), userMaggie);
        Order orderSnoopy = new Order(null, Instant.parse("2021-10-24T08:00:00Z"), userSnoopy);
        Order orderMalu = new Order(null, Instant.parse("2021-11-25T07:59:59Z"), userMalu);


        //-------------------------   Salvando os dados no banco de dados   --------------------------------------------
        //  Salvando o usuário no banco de dados
        userRepository.saveAll(Arrays.asList(userNina, userFred, userSnow, userMaggie, userSnoopy, userMalu));
        // userRepository.save(userFred);  --- >>>     Salvando um unico usuário no banco de dados (Outra forma)
        //  Salvando os PEDIDOS no banco de dados
        orderRepository.saveAll(Arrays.asList(orderNina, order2Nina, orderFred, orderSnow, orderMaggie, orderSnoopy, orderMalu));

    }
}
