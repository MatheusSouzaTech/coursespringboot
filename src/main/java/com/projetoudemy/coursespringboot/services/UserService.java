package com.projetoudemy.coursespringboot.services;

import com.projetoudemy.coursespringboot.entities.User;
import com.projetoudemy.coursespringboot.repositories.UserRepository;
import com.projetoudemy.coursespringboot.services.exceptions.DatabaseException;
import com.projetoudemy.coursespringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //metodo que lança uma exeção caso não tenha um id com o usuario selecionado
    }

    public User insert(User obj){ //insere no banco de dados um novo usuario chamado User
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
