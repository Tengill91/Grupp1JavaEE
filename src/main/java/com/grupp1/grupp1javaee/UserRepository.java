package com.grupp1.grupp1javaee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<UserModel,Integer> {


}
