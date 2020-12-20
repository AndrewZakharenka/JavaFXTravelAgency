package com.service.user;

import com.service.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserByLogin(String login);

    UserDTO createUser(UserDTO userDTO);
}
