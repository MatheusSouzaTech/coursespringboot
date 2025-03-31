package com.projetoudemy.coursespringboot.config;

import com.projetoudemy.coursespringboot.entities.Order;
import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.repositories.OrderRepository;
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


    @Override
    public void run(String... args) throws Exception {
        //tudo que for colocado neste metodo sera executado quando a aplicação for iniciada

        User u1 = new User(null,"Maria Brown", "maria@gmail.com","9888888","12345");
        User u2 = new User(null,"Alex Green", "alex@gmail.com", "977777466", "123456");
        User u3 = new User(null,"Kaique","kaique@gmail.com","999999999","14577");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),u1);

        //puxando a dependencia que acessa os dados e salvando dos os dados coletados dentro do banco atraves da inserção de dependencias por um array
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }

}
