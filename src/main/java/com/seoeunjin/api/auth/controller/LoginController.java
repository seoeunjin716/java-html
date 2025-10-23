package com.seoeunjin.api.auth.controller;

import org.springframework.web.bind.annotation.*;

import com.seoeunjin.api.auth.domain.LoginDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Map;
import com.seoeunjin.api.auth.service.LoginService;
import com.seoeunjin.api.common.domain.Messenger;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
        }
    
    @GetMapping("/api/login")
    public String login(@RequestParam("email") String email, 
    @RequestParam("password") String password, Model model) {
        System.out.println("컨트롤러로 들어옴");
        System.out.println("화면에서 컨트롤러로 전달된 이메일 : " + email);
        System.out.println("화면에서 컨트롤러로 전달된 비밀번호 : " + password);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        Messenger messenger = loginService.login(loginDTO);

        System.out.println("서비스에서 컨트롤러로 전달된 코드 : " + messenger.getCode());
        System.out.println("서비스에서 컨트롤러로 전달된 메시지 : "+ messenger.getMessage());

        model.addAttribute("messenger", messenger);

        return "auth/login";
        
    }
}
