package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Slf4j
public class TestController {

    @GetMapping("/aa")
    @PreAuthorize("hasRole('ROLE_admin')")
    public String getUserById(HttpServletRequest httpRequest) {
        return "out success";
    }

}
