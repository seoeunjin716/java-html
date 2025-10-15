package com.seoeunjin.api.auth.controller;

import org.springframework.web.bind.annotation.*;

import com.seoeunjin.api.auth.domain.LoginDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Map;
import com.seoeunjin.api.auth.service.LoginService;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
        }
    
    @GetMapping("/api/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 이메일 : " + email);
        System.out.println("화면에서 컨트롤러로 전달된 비밀번호 : " + password);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        loginService.login(loginDTO);

        return "auth/login";
        
    }
}
