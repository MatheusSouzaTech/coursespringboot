package com.projetoudemy.coursespringboot.services;

import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Registra esta classe como componente do spring permitindo que ele seja injetado automaticamente com o Autowired
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj){ //insere no banco de dados um novo usuario chamado User
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
