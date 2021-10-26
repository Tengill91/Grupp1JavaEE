package com.grupp1.grupp1javaee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
            .authorizeRequests()
            .antMatchers("/", "/home").permitAll()  // Only these can be accesed by ANYONE
                    .antMatchers("/users").hasRole("ADMIN") // Only Admin can enter
                    .antMatchers("/saveUser").hasRole("ADMIN") // Only Admin can enter
                    .antMatchers("/editUser/{id}").hasRole("ADMIN") // Only Admin can enter
                    .antMatchers("/updateUser/{id}").hasRole("ADMIN") // Only Admin can enter
                    .antMatchers("/deleteUser/{id}").hasRole("ADMIN") // Only Admin can enter
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





                        /*
                        *
            *.requestMatchers()
                .antMatchers("/api/customer/**")
                .and()
            .authorizeRequests()
                .antMatchers("/**").hasRole("CUSTOMER")
                .and()
            .apply(yourJointConfigurations());*/

    // .inMemoryAuthentication().withUser("user").password("password").roles("USER");

}





   @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("u")
                        .password("p")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }





}
