package com.projetoudemy.coursespringboot.config;

import com.projetoudemy.coursespringboot.entities.Category;
import com.projetoudemy.coursespringboot.entities.Order;
import com.projetoudemy.coursespringboot.entities.Products;
import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.entities.enums.OrderStatus;
import com.projetoudemy.coursespringboot.repositories.CategoryRepository;
import com.projetoudemy.coursespringboot.repositories.OrderRepository;
import com.projetoudemy.coursespringboot.repositories.ProductsRepository;
import com.projetoudemy.coursespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Injeção de dependencias
    @Autowired //Resolve a dependencia e associa uma instancia do userRepository no testConfig
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public void run(String... args) throws Exception {
        //tudo que for colocado neste metodo sera executado quando a aplicação for iniciada

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Products p1 = new Products(null,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur",90.5,"");
        Products p2 = new Products(null, "Smart TV", "Nulla eu imperdiet purus, Maecenas ante.", 2190.0,"");
        Products p3 = new Products(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.",150.0,"");
        Products p4 = new Products(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus", 120.0,"");
        Products p5 = new Products(null, "Rails for Dumies", "Cras fringilla convallis sem vel faucibus", 100.99,"");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productsRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null,"Maria Brown", "maria@gmail.com","9888888","12345");
        User u2 = new User(null,"Alex Green", "alex@gmail.com", "977777466", "123456");
        User u3 = new User(null,"Kaique","kaique@gmail.com","999999999","14577");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);



        //puxando a dependencia que acessa os dados e salvando dos os dados coletados dentro do banco atraves da inserção de dependencias por um array
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));


    }

}
