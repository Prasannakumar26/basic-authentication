package com.example.demo.Service;

import com.example.demo.Model.Login;
import com.example.demo.Repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;
    public Boolean loginUser(Long mobileNumber, String password) {
        Optional<Login> login = repository.findById(mobileNumber);
        if(login.isPresent() ){
            if (mobileNumber.equals(login.get().getMobileNumber()) && password.equals(login.get().getPassword())) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}