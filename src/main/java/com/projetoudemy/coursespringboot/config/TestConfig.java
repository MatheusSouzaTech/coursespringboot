package com.projetoudemy.coursespringboot.config;

import com.projetoudemy.coursespringboot.entities.Category;
import com.projetoudemy.coursespringboot.entities.Order;
import com.projetoudemy.coursespringboot.entities.Product;
import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.entities.enums.OrderStatus;
import com.projetoudemy.coursespringboot.repositories.CategoryRepository;
import com.projetoudemy.coursespringboot.repositories.OrderRepository;
import com.projetoudemy.coursespringboot.repositories.ProductRepository;
import com.projetoudemy.coursespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // Esta configuração será ativada apenas no perfil 'test'
public class TestConfig implements CommandLineRunner {

    // Injeção de dependências dos repositórios
    @Autowired // Injeta automaticamente uma instância do UserRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Este metodo será executado automaticamente ao iniciar a aplicação no perfil 'test'

        // Criação de categorias
        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        // Criação de produtos
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus, Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 150.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus", 120.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus", 100.99, "");

        // Salvando categorias no banco
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Salvando produtos no banco
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Associando categorias aos produtos
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        // Atualizando os produtos com as categorias associadas
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Criação de usuários
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888", "12345");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777466", "123456");
        User u3 = new User(null, "Kaique", "kaique@gmail.com", "999999999", "14577");
        User u4 = new User(null, "Matheus", "teste@gmail.com", "9888888", "12348");

        // Criação de pedidos e associação aos usuários
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);

        // Salvando usuários no banco
        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        // Salvando pedidos no banco
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
