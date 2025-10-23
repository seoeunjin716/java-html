package com.seoeunjin.api.user.service;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.user.domain.UserDTO;
import com.seoeunjin.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public Messenger getTop5Passengers(List<UserDTO> users){


            // ✅ Repository로 넘겨서 처리
            Messenger messenger = userRepository.readTop5Passengers(users);
            
        return messenger;
    }

}
