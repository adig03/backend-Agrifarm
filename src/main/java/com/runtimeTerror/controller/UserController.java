package com.runtimeTerror.controller;

import com.runtimeTerror.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
@GetMapping
public  String x(){
    return "test";
}


}
