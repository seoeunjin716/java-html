package com.seoeunjin.api.auth.service;

import org.springframework.stereotype.Service;

import com.seoeunjin.api.auth.domain.LoginDTO;

@Service
public class LoginService {
    
    public boolean login(LoginDTO loginDTO) {
        System.out.println("로그인 서비스로 들어옴");
        System.out.println("DTO에서 서비스로 전달된 이메일 : " + loginDTO.getEmail());
        System.out.println("DTO에서 서비스로 전달된 비밀번호 : " + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO()

    System.out.println("VO에서 서비스로 전달된 이메일 : " + loginVO.getEmail());
    System.out.println("VO에서 서비스로 전달된 비밀번호 : " + loginVO.getPassword());
    
        return true;
    }

}
