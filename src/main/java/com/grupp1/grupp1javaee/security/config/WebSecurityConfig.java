package com.grupp1.grupp1javaee.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/test").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/index").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/new").hasAuthority("ADMIN")
                .antMatchers("/home").permitAll()
                .antMatchers("/login").hasAnyAuthority("ADMIN","USER")
                .anyRequest().authenticated()
                .and().formLogin();
    }*/



    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
            .authorizeRequests()
            .antMatchers("/", "/home", "/createAccount","/saveUser").permitAll()  // Only these can be accesed by ANYONE
                    .antMatchers("/users").hasAuthority("ADMIN") // Only Admin can enter
                    .antMatchers("/newUser").hasAuthority("ADMIN") // Only Admin can enter
                    .antMatchers("/editUser/{id}").hasAuthority("ADMIN") // Only Admin can enter
                    .antMatchers("/updateUser/{id}").hasAuthority("ADMIN") // Only Admin can enter
                    .antMatchers("/deleteUser/{id}").hasAuthority("ADMIN") // Only Admin can enter
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .authorizeRequests();


    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){return NoOpPasswordEncoder.getInstance();
    }











}
