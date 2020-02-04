package com.ucong.security;

import com.ucong.exception.ResourceNotFoundException;
import com.ucong.user.User;
import com.ucong.user.UserRepository;
import com.ucong.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername (String usernameOrEmail)
        throws UsernameNotFoundException {

        User user = userService.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                        .orElseThrow(()-> new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));

        return UserPrincipal.create(user);
    }

    @Transactional
    public  UserDetails loadUserById(UUID id){
        User user = userService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found"));

        return UserPrincipal.create(user);
    }
}
