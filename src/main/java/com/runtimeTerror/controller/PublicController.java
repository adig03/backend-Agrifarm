package com.runtimeTerror.controller;

import com.runtimeTerror.services.UserService;
import com.runtimeTerror.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;


    @PostMapping("/adduser")
    public ResponseEntity<?> createuser(@RequestBody User user){
        String email=user.getEmail();
        if(email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){


        try {
            userService.savenewUser(user);
            return new ResponseEntity("Added sucessfully", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(e,HttpStatus.NO_CONTENT);
        }
    }



    else{
            return new ResponseEntity("cannot add user",HttpStatus.NO_CONTENT);

    }
}
}
