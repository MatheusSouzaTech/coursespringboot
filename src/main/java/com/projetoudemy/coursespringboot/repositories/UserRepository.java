package com.projetoudemy.coursespringboot.repositories;

import com.projetoudemy.coursespringboot.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
