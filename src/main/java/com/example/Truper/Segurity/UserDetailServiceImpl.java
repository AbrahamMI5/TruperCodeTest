package com.example.Truper.Segurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO: obtener los datos del usuario de la base de datos
        String authorities = "";
        if(!"admin".equals(username)) {
            new UsernameNotFoundException("Username not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password("admin")
                .roles(authorities)
                .build();
    }
}
