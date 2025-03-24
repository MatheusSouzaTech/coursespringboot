package com.projetoudemy.coursespringboot.config;

import com.projetoudemy.coursespringboot.User;
import com.projetoudemy.coursespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Injeção de dependencias
    @Autowired //Resolve a dependencia e associa uma instancia do userRepository no testConfig
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        //tudo que for colocado neste metodo sera executado quando a aplicação for iniciada

        User u1 = new User(null,"Maria Brown", "maria@gmail.com","9888888","12345");
        User u2 = new User(null,"Alex Green", "alex@gmail.com", "977777466", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
