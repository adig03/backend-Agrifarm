package com.runtimeTerror.services;

import com.runtimeTerror.repository.UserRepository;
import com.runtimeTerror.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        User user;

        // Check if the input is an email or a username
        if (identifier.contains("@")) {
            user = userRepository.findByEmail(identifier); // Try to fetch by email
        } else {
            user = userRepository.findByUsername(identifier); // Try to fetch by username
        }

        if (user != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername()) // Set username
                    .password(user.getPassword()) // Set password
                    .roles(user.getRole().toArray(new String[0])) // Set roles
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with: " + identifier);
        }
    }
}
