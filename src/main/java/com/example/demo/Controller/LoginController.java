package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/api/login")
    public ResponseEntity<String> loginUser(@RequestParam Long mobileNumber, @RequestParam String password){
        if (service.loginUser(mobileNumber, password)){
            return new ResponseEntity<String>("Login successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("Invalid login details", HttpStatus.BAD_REQUEST);
        }
    }
}