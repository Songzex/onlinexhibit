package com.example.controller;

import com.example.R.ResponseResult;
import com.example.config.JwtUtils;
import com.example.dto.LoginFrom;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.JwtBlacklist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/public")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private  JwtUtils jwtUtils;
    @Autowired
    private JwtBlacklist jwtBlacklist;
    @PostMapping("/login")
    public ResponseResult<User> getAllUsers(@RequestBody LoginFrom from ) {
        log.info("login....");
        String password = userService.login(from.getEmail());
        if (!password.isEmpty()&& password.equals(new BCryptPasswordEncoder().encode(from.getPassword()))){
            String token = jwtUtils.generateToken(from.getEmail());
            ResponseResult.success(token);
        }
        return  ResponseResult.fail(null,"email don't register or password is no correct ");
    }

    @PostMapping("/register")
    public ResponseResult<String> createUser(@RequestBody User user,String roles) {
        String password = userService.login(user.getEmail());
        System.out.println(roles + "@@@@@@@@@@@@");
        if (password == null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            String token = jwtUtils.generateToken(user.getEmail());
            userService.register(user, roles);
            return ResponseResult.success(token);
        } else {
            return ResponseResult.fail(null, "email has used ");
        }
    }
    @GetMapping("/logout")
    public String getUserById(HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("Authorization");
        jwtBlacklist.addToBlacklist(token);
        return "out success";
    }
    @GetMapping("/test")
    public String getUserById() {

        return "test success";
    }
}
