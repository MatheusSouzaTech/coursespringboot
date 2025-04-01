package com.projetoudemy.coursespringboot.repositories;


import com.projetoudemy.coursespringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {




}
