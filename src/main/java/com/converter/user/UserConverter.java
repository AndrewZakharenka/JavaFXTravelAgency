package com.converter.user;

import com.converter.AbstractConverter;
import com.dao.entity.user.UserEntity;
import com.service.dto.user.UserDTO;

public class UserConverter extends AbstractConverter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getSurname(),
                userEntity.getLogin(), userEntity.getPassword(), userEntity.getRole());
    }

    public UserEntity convertReverse(UserDTO userDTO){
        return new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getSurname(), userDTO.getLogin(),
                userDTO.getPassword(), userDTO.getRole());
    }
}
