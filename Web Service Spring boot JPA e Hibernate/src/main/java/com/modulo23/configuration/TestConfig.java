package com.modulo23.configuration;

import com.modulo23.entities.Category;
import com.modulo23.entities.Order;
import com.modulo23.entities.Product;
import com.modulo23.entities.User;
import com.modulo23.entities.enuns.OrderStatus;
import com.modulo23.repositories.RepositoryCategry;
import com.modulo23.repositories.RepositoryOrder;
import com.modulo23.repositories.RepositoryProduct;
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

    //?--------------------------------------   Injeção de dependência   -----------------------------------------------
    @Autowired
    private RepositoryUser userRepository;

    @Autowired
    private RepositoryOrder orderRepository;

    @Autowired
    private RepositoryCategry categoryRepository;

    @Autowired
    private RepositoryProduct productRepository;

    @Override
    public void run(String... args) throws Exception { // Método que será executado quando a aplicação for iniciada

        //?------------------------   Criação de uns usuários para teste   ---------------------------------------------
        User userNina = new User(null, "Nina", "nina@gmail.com", "6191112222", "1111");
        User userFred = new User(null, "Frederico", "frederico@gmail.com", "6192223333", "2222");
        User userSnow = new User(null, "Snow", "snow@gmail.com", "6191114444", "3333");
        User userMaggie = new User(null, "Maggie", "maggie@gmail.com", "6194445555", "4444");
        User userSnoopy = new User(null, "Snoopy", "snoopy@gmail.com", "6195556666", "5555");
        User userMalu = new User(null, "Malu", "malu@gmail.com", "6196667777", "6666");


        //?-------------------------   Criação de alguns pedidos para teste   ------------------------------------------
        Order orderSnoopy2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, userNina);
        Order orderNina = new Order(null, Instant.parse("2021-06-20T19:53:07Z"), OrderStatus.PAID, userNina);
        Order orderNina2 = new Order(null, Instant.parse("2021-06-18T19:53:07Z"), OrderStatus.DELIVERED, userNina);
        Order orderFred = new Order(null, Instant.parse("2021-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, userFred);
        Order orderSnow = new Order(null, Instant.parse("2021-08-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, userSnow);
        Order orderMaggie = new Order(null, Instant.parse("2021-09-23T09:10:55Z"), OrderStatus.PAID, userMaggie);
        Order orderSnoopy = new Order(null, Instant.parse("2021-10-24T08:00:00Z"), OrderStatus.SHIPPED, userSnoopy);
        Order orderMalu = new Order(null, Instant.parse("2021-11-25T07:59:59Z"), OrderStatus.DELIVERED, userMalu);


        //?-------------------------   Criação de alguns produtos para teste   -----------------------------------------
        Product produto1 = new Product(null, "TV", "TV 32 polegadas", 1299.89, "");
        Product produto2 = new Product(null, "Mouse", "Mouse sem fio Logitec", 89.90, "");
        Product produto3 = new Product(null, "Mesa de escritório", "Mesa de escritório em madeira mogno", 478.35, "");
        Product produto4 = new Product(null, "Toalha", "Toalha de banho branca Casteca", 58.80, "");
        Product produto5 = new Product(null, "Colcha", "Colcha de cama quadriculada keylog", 135.48, "");

        Product produto6 = new Product(null, "Alexa", "Assitente virtual", 399.99, "");
        Product produto7 = new Product(null, "Sofá", "Sofá Reclinavel 3 lugares", 2786.65, "");
        Product produto8 = new Product(null, "Cama", "Cama Casal King ", 1845.50, "");
        Product produto9 = new Product(null, "Guarda Roupas", "Guarda Roupas Casal 6 portas", 2175.00, "");
        Product produto10 = new Product(null, "Filtro", "Filtro filtro mais 4 Litros plus", 989.99, "");

        //?-------------------------   Criação de alguma Categorias para teste   ---------------------------------------
        Category categoria1 = new Category(null, "Eletro e Eletronicos");
        Category categoria2 = new Category(null, "Móveis");
        Category categoria3 = new Category(null, "Casa e Jardim");
        Category categoria4 = new Category(null, "Vestuario");
        Category categoria5 = new Category(null, "Esporte e Lazer");




        //?-------------------------   Salvando os dados no banco de dados   -------------------------------------------
        //!  Salvando o usuário no banco de dados
        userRepository.saveAll(Arrays.asList(userNina, userFred, userSnow, userMaggie, userSnoopy, userMalu));
        // userRepository.save(userFred);  --- >>>     Salvando um unico usuário no banco de dados (Outra forma)

        //!  Salvando os PEDIDOS no banco de dados
        orderRepository.saveAll(Arrays.asList(orderNina, orderNina2, orderFred, orderSnow, orderMaggie, orderSnoopy, orderMalu, orderSnoopy2));

        //!  Salvando as CATEGORIAS no banco de dados
        categoryRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4, categoria5));

        //!  Salvando os PRODUTOS no banco de dados
        productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9, produto10));

    }
}
