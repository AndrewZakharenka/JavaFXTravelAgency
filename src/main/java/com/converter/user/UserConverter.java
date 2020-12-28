package com.converter.user;

import com.converter.AbstractConverter;
import com.dao.entity.role.RoleEntity;
import com.dao.entity.user.UserEntity;
import com.service.dto.user.UserDTO;

public class UserConverter extends AbstractConverter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity userEntity) {
        if (userEntity == null){
            return new UserDTO();
        } else {
            return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getSurname(),
                    userEntity.getLogin(), userEntity.getPassword(), userEntity.getRoleEntity().getName());
        }
    }

    public UserEntity convertReverse(UserDTO userDTO){
        return new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getSurname(), userDTO.getLogin(),
                userDTO.getPassword(), new RoleEntity(2, userDTO.getRole()));
    }
}
