package com.modulo23.configuration;

import com.modulo23.entities.Order;
import com.modulo23.entities.User;
import com.modulo23.entities.enuns.OrderStatus;
import com.modulo23.repositories.RepositoryOrder;
import com.modulo23.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.jaxb.OrderAdapter;

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
        Order orderSnoopy2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, userNina);
        Order orderNina = new Order(null, Instant.parse("2021-06-20T19:53:07Z"),OrderStatus.PAID, userNina);
        Order orderNina2 = new Order(null, Instant.parse("2021-06-18T19:53:07Z"),OrderStatus.DELIVERED, userNina);
        Order orderFred = new Order(null, Instant.parse("2021-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, userFred);
        Order orderSnow = new Order(null, Instant.parse("2021-08-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, userSnow);
        Order orderMaggie = new Order(null, Instant.parse("2021-09-23T09:10:55Z"),OrderStatus.PAID, userMaggie);
        Order orderSnoopy = new Order(null, Instant.parse("2021-10-24T08:00:00Z"),OrderStatus.SHIPPED, userSnoopy);
        Order orderMalu = new Order(null, Instant.parse("2021-11-25T07:59:59Z"),OrderStatus.DELIVERED, userMalu);


        //-------------------------   Salvando os dados no banco de dados   --------------------------------------------
        //  Salvando o usuário no banco de dados
        userRepository.saveAll(Arrays.asList(userNina, userFred, userSnow, userMaggie, userSnoopy, userMalu));
        // userRepository.save(userFred);  --- >>>     Salvando um unico usuário no banco de dados (Outra forma)
        //  Salvando os PEDIDOS no banco de dados
        orderRepository.saveAll(Arrays.asList(orderNina, orderNina2, orderFred, orderSnow, orderMaggie, orderSnoopy, orderMalu,orderSnoopy2));

    }
}
