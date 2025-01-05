package com.anika.SpringSecurityProject.UserController;

import com.anika.SpringSecurityProject.Model.User;
import com.anika.SpringSecurityProject.Model.Users;
import com.anika.SpringSecurityProject.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;
    List<User> users= new ArrayList<>(List.of(
            new User(1,"Anika",28),
            new User(2,"Nari",26),
            new User(3,"Yadav",25)

    ));

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        users.add(user);
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/csrf")
    public ResponseEntity<Object> getCsrfToken(HttpServletRequest request){
        return  ResponseEntity.ok(request.getAttribute("_csrf"));
    }



}
