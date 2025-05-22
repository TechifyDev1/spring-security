package com.qudus.springsec.service;

import com.qudus.springsec.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.qudus.springsec.model.Users;
import com.qudus.springsec.repo.UserRepo;

// This class implements UserDetailsService to load user-specific data.
// It is used by the authentication manager to retrieve user details for authentication.
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    // This method is used to load user details by username.
    // It is called by the authentication manager during the authentication process.s
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // This method retrieves user details from the database using the UserRepo.
        // It returns a UserDetails object that contains user information such as username, password, and roles.

        Users user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException(username);
        }
        System.out.println("User found: " + user);

        return new UserPrinciple(user);
    }
    
}
