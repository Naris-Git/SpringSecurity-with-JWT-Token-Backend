package com.anika.SpringSecurityProject.UserController;

import com.anika.SpringSecurityProject.Model.Users;
import com.anika.SpringSecurityProject.Service.UsersRegistrationService;
import com.anika.SpringSecurityProject.TokenDTO.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersRegistrationController {

    @Autowired
    private UsersRegistrationService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return service.register(users) ;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users users){

        System.out.println("User details : " + users);
        return ResponseEntity.ok(service.verify(users)) ;

    }
}
