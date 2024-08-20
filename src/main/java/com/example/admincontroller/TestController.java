package com.example.admincontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@Slf4j
public class TestController {

    @GetMapping("/aa")
    @PreAuthorize("hasRole('ROLE_admin')")//admin是拼上去的角色
    public String getUserById(HttpServletRequest httpRequest) {
        return "out success";
    }

    @GetMapping("/info")
    @PreAuthorize("hasAuthority('user:read')")
    public String userInfo() {
        return "User Info: This is some user information.";
    }

}
