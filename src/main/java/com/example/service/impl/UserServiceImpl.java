package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.pojo.UserRole;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer getRByemail(String username) {
        return userMapper.getRByemail(username);
    }

    @Override
    public List<UserRole> getRoleByrid(Integer rid) {
        return userMapper.getRoleByrid(rid);
    }

    @Override
    public void register(User user,String Role) {
      userMapper.register(user);
        Integer id = userMapper.getRByemail(user.getEmail());
        UserRole userRole = new UserRole(Role, id);
        userMapper.addRole(userRole);
    }

    @Override
    public String login(String email) {
        return userMapper.login(email);
    }

    @Override
    public void addRole(UserRole userRole) {
           userMapper.addRole(userRole);
    }
}
