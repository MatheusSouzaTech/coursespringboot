package com.projetoudemy.coursespringboot.resources;

import com.projetoudemy.coursespringboot.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Especificando a classe como controlador

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //Criando o metodo para resposta de requisições web
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria","maria@gmail.com","9999999","12345");
        return ResponseEntity.ok().body(u);
    }

}
