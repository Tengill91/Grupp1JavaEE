package com.grupp1.grupp1javaee.security.config;

import com.grupp1.grupp1javaee.User.UserModel;
import com.grupp1.grupp1javaee.User.UserRepository;
import com.grupp1.grupp1javaee.security.config.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByUserName(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("Not found"+ userName));
        return user.map(MyUserDetails::new).get();
    }


}
