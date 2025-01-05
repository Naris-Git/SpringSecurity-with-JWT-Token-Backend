package com.anika.SpringSecurityProject.Service;

import com.anika.SpringSecurityProject.Model.Users;
import com.anika.SpringSecurityProject.Repository.UsersRepository;
import com.anika.SpringSecurityProject.TokenDTO.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersRegistrationService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);

    public Users register(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return repository.save(users);
    }

    public String verify(Users users) {
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(),users.getPassword()));

        if(authentication.isAuthenticated()){
           return jwtService.generateToken(users.getUserName());
        }
        else {
            return "null";
        }

    }
}
