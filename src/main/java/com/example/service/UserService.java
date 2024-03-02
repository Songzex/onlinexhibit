package com.example.service;

import com.example.pojo.User;
import com.example.pojo.UserRole;

import java.util.List;

public interface UserService  {
    Integer getRByemail(String username);
    List<UserRole> getRoleByrid(Integer rid);
    void register(User user ,String userRole);
    String login(String email);
    void  addRole(UserRole userRole);

}
