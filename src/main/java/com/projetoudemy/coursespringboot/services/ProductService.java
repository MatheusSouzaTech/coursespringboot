package com.projetoudemy.coursespringboot.services;


import com.projetoudemy.coursespringboot.entities.Product;
import com.projetoudemy.coursespringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Registra esta classe como componente do spring permitindo que ele seja injetado automaticamente com o Autowired
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
