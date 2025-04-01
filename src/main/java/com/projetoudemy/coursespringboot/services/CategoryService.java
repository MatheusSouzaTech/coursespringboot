package com.projetoudemy.coursespringboot.services;

import com.projetoudemy.coursespringboot.entities.Category;
import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.repositories.CategoryRepository;
import com.projetoudemy.coursespringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Registra esta classe como componente do spring permitindo que ele seja injetado automaticamente com o Autowired
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
