package com.runtimeTerror;


import com.runtimeTerror.models.User;
import com.runtimeTerror.Repsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    public UserRepository userRepository;
    private static final PasswordEncoder passwordencoder = new BCryptPasswordEncoder();
    public void saveUser(User user){
        userRepository.save(user);
    }





}
