package com.seoeunjin.api.user.service;


import java.util.List;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.user.domain.UserDTO;


public interface UserService {

    Messenger save(UserDTO user);
    Messenger saveAll(List<UserDTO> users);
    Messenger update(UserDTO user);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();

}



