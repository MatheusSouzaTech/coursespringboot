package com.projetoudemy.coursespringboot.repositories;

import com.projetoudemy.coursespringboot.entities.OrderItem;
import com.projetoudemy.coursespringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
