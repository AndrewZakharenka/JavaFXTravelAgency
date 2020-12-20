package com.dao.user;

import com.dao.DAO;
import com.dao.entity.user.UserEntity;

public interface UserDAO extends DAO<UserEntity> {
    UserEntity getByLogin(String login);
}
