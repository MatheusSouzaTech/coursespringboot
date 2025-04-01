package com.projetoudemy.coursespringboot.repositories;


import com.projetoudemy.coursespringboot.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {




}
