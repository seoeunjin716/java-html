package com.seoeunjin.api.auth.service;

import org.springframework.stereotype.Service;

import com.seoeunjin.api.auth.domain.LoginDTO;
import com.seoeunjin.api.auth.domain.LoginVO;
import com.seoeunjin.api.common.domain.Messenger;

@Service
public class LoginService {
    
    public Messenger login(LoginDTO loginDTO) {
        System.out.println("로그인 서비스로 들어옴");
        System.out.println("DTO에서 서비스로 전달된 이메일 : " + loginDTO.getEmail());
        System.out.println("DTO에서 서비스로 전달된 비밀번호 : " + loginDTO.getPassword());

        LoginVO loginVO = new LoginVO();
        
        System.out.println("VO에서 서비스로 전달된 이메일 : " + loginVO.getEmail());
        System.out.println("VO에서 서비스로 전달된 비밀번호 : " + loginVO.getPassword());

        int code = 0;
        String messege = "";

        if(loginVO.getEmail().equals(loginDTO.getEmail())
        && loginVO.getPassword().equals(loginDTO.getPassword())){
           code=0; 
           messege="로그인 성공";
        }
        else if(!loginVO.getEmail().equals(loginDTO.getEmail())
        && loginVO.getPassword().equals(loginDTO.getPassword())) {
            code=1;
            messege="이메일 불일치";        } //이메일 불일치
        else if(loginVO.getEmail().equals(loginDTO.getEmail())
        && !loginVO.getPassword().equals(loginDTO.getPassword())) {
            code=2;
            messege="비밀번호 불일치";} //비밀번호 불일치

        else{code=3;
        messege="이메일과 비밀번호 모두 불일치";}

        Messenger messenger = new Messenger();
        messenger.setCode(code);
        messenger.setMessage(messege);
        return messenger;

    }

}
