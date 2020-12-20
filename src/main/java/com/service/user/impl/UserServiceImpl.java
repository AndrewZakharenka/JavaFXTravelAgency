package com.service.user.impl;

import com.converter.IConverter;
import com.converter.user.UserConverter;
import com.dao.entity.user.UserEntity;
import com.dao.impl.mysql.user.MySqlUserDAO;
import com.dao.user.UserDAO;
import com.service.dto.user.UserDTO;
import com.service.user.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new MySqlUserDAO();
    private IConverter<UserEntity, UserDTO> converter = new UserConverter();

    @Override
    public List<UserDTO> getAllUsers() {
        return converter.convertAll(userDAO.getAll());
    }

    @Override
    public UserDTO getUserByLogin(String login){
        return converter.convert(userDAO.getByLogin(login));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO){
        return converter.convert(userDAO.create(converter.convertReverse(userDTO)));
    }
}
