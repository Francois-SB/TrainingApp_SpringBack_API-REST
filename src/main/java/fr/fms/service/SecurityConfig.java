package fr.fms.service;

import fr.fms.entities.AppRole;
import fr.fms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.Collection;

public class SecurityConfig {
    @Autowired
    AccountServiceImpl accountService;
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().anyRequest().permitAll();

    }
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                User user = accountService.getUserByUsername(username);
//                Collection<GrantedAuthority> authorities = new ArrayList<>();
//                user.getRoles().forEach( role -> {
//                    authorities.add(new SimpleGrantedAuthority(role.getRolename()));
//                });
//                return new User(user.getUsername(),user.getPassword(),authorities);
//            }
//        });
//    }
}
