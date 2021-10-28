package com.grupp1.grupp1javaee.Repository;

import com.grupp1.grupp1javaee.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

    Optional<UserModel> findByUserName(String userName);

    //In this case a query annotation is not need since spring constructs the query from the method name


}
