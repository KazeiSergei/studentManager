package com.courses.spring.service;

import com.courses.spring.model.User;
import com.courses.spring.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);
    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = userService.getByLogin(login.toUpperCase());
        System.out.println("User : " + user);
        if (user == null) {
            LOGGER.error("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new SecurityUser(user);
    }
}
