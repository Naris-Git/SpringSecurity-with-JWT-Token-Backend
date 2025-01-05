package com.anika.SpringSecurityProject.Service;

import com.anika.SpringSecurityProject.Repository.UserRepository;
import com.anika.SpringSecurityProject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

     @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
