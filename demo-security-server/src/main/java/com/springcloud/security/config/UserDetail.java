package com.springcloud.security.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetail {

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user=new User("lr","123456",null);
        if(s.equals("lr")){
            return user;
        }
        return null;
    }
}
