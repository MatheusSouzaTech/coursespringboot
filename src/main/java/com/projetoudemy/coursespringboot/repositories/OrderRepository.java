package com.projetoudemy.coursespringboot.repositories;

import com.projetoudemy.coursespringboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
