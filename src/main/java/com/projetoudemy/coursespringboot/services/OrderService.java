package com.projetoudemy.coursespringboot.services;

import com.projetoudemy.coursespringboot.entities.Order;
import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Registra esta classe como componente do spring permitindo que ele seja injetado automaticamente com o Autowired
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
