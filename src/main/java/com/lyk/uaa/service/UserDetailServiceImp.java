package com.lyk.uaa.service;

import com.lyk.uaa.dao.UserDao;
import com.lyk.uaa.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDto userDto = userDao.selectByUsername(s);
        if (userDto == null){
            return null;
        }
        return  User.withUsername(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
}
