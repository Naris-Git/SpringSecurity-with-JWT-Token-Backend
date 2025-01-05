package com.anika.SpringSecurityProject.UserController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {
    @GetMapping("/")
    public ResponseEntity<String> greet(HttpServletRequest request){
        return  ResponseEntity.ok("Hello User.."+request.getSession().getId());
    }
}
