package com.bht.humanresources.service;

import com.bht.humanresources.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.bht.humanresources.dao.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if(user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(user.getEmail());
            builder.password(user.getPassword()); //create a new user role array
            builder.roles(user.getRole());

        }else {
            throw new UsernameNotFoundException("username not found");
        }
        return builder.build();
       // return new org.springframework.security.core.userdetails.User(user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getRole());
    }
}
