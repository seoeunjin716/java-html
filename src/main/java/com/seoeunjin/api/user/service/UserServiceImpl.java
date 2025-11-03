package com.seoeunjin.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.user.domain.UserDTO;
import com.seoeunjin.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Messenger save(UserDTO user) {
        return userRepository.save(user);
    }

    @Override
    public Messenger saveAll(List<UserDTO> users) {
        Messenger messenger = userRepository.saveAll(users);
        return messenger;
    }

    @Override
    public Messenger update(UserDTO user) {
        return userRepository.update(user);
    }

    @Override
    public Messenger delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return userRepository.findAll();
    }

}
