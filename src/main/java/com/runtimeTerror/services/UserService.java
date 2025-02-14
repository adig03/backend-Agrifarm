package com.runtimeTerror.services;


import com.runtimeTerror.models.User;
import com.runtimeTerror.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    public UserRepository userRepository;
    private static final PasswordEncoder passwordencoder = new BCryptPasswordEncoder();
    public void savenewUser(User user){
        user.setPassword(passwordencoder.encode(user.getPassword()));
        userRepository.save(user);
    }





}
