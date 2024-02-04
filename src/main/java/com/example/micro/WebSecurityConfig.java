package com.example.micro;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

  @Autowired
  private UserDetailsService userDetailsService;

  //    Начиная с версии 5.7.0-M2 WebSecurityConfigurerAdapter был удалён (мной использовалась версия 6.0.2)
//    код ниже ещё не доступен
//    ссылка на изменения
//    https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter/
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/" ,"/home" ,"/t" ,"/p").permitAll()
            .requestMatchers("/hello" ,"/lol" ,"/kek").hasRole("ADMIN")
            .anyRequest().authenticated())
        .formLogin((form) -> form
            .loginPage("/login")
            .permitAll())
        .logout((logout) -> logout.permitAll());
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    List<UserDetails> userList = new ArrayList<UserDetails>();
    UserDetails user =
        User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
    UserDetails admin =
        User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();
    userList.add(user);
    userList.add(admin);
    return new InMemoryUserDetailsManager(userList);
  }

}
