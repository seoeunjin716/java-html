package com.seoeunjin.api.auth.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("email") String email, 
                                   @RequestParam("password") String password) {
        
        // 콘솔에 로그인 정보 출력
        System.out.println("=== 로그인 요청 정보 ===");
        System.out.println("🧞‍♀️🤠이메일: " + email);
        System.out.println("😍🤩비밀번호: " + password);
        System.out.println("========================");
        
        // 응답 반환
        return ResponseEntity.ok().body(Map.of(
            "message", "로그인 정보가 성공적으로 받아졌습니다.",
            "email", email
        ));
    }
}
