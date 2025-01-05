package com.anika.SpringSecurityProject.Service;

import com.anika.SpringSecurityProject.Model.MyUserDetails;
import com.anika.SpringSecurityProject.Model.Users;
import com.anika.SpringSecurityProject.Repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    //private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users=usersRepository.findByUsername(username);

        if(users==null){
            System.out.println("User is not found" +" : "+username);
            throw new UsernameNotFoundException("User not found.");
        }

            return new MyUserDetails(users);



    }
}
