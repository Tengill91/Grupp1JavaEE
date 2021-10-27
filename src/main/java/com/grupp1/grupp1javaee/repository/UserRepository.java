package com.grupp1.grupp1javaee.repository;

import com.grupp1.grupp1javaee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {

    Optional <User> findByUserName (String username);
}
