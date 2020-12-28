package com.dao.impl.mysql.user;

import com.dao.entity.fields.user.UserEntityFields;
import com.dao.entity.query.user.UserQuery;
import com.dao.entity.role.RoleEntity;
import com.dao.entity.user.UserEntity;
import com.dao.exception.DAOException;
import com.dao.impl.mysql.MySqlAbstractDAO;
import com.dao.user.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlUserDAO extends MySqlAbstractDAO<UserEntity> implements UserDAO {

    @Override
    public UserEntity getByLogin(String login) {
        Optional<Connection> connectionOptional = getConnection();
        UserEntity user = new UserEntity();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement statement = connection.prepareStatement(UserQuery.GET_USER_BY_LOGIN)) {
                statement.setString(1, login);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    user = getUserEntityFromResultSet(resultSet);
                }
                return user;
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to get user");
            }
        }
        return user;
    }

    @Override
    public UserEntity create(UserEntity entity) throws DAOException {
        Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement statement = connection.prepareStatement(UserQuery.INSERT_USER)){
                statement.setString(1, entity.getName());
                statement.setString(2, entity.getSurname());
                statement.setString(3, entity.getLogin());
                statement.setString(4, entity.getPassword());
                statement.setLong(5, 2);
                statement.execute();
                return getByLogin(entity.getLogin());
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to create user");
            }
        }
        return entity;
    }

    @Override
    public Optional<UserEntity> getEntity(long id) throws DAOException {
        return Optional.empty();
    }

//    @Override
//    public UserEntity getEntity(long id) throws DAOException {
//        Optional<Connection> connectionOptional = getConnection();
//        UserEntity user = new UserEntity();
//        if (connectionOptional.isPresent()) {
//            try (Connection connection = connectionOptional.get();
//                 PreparedStatement statement = connection.prepareStatement(UserQuery.GET_USER_BY_ID)) {
//                statement.setLong(1, id);
//                ResultSet resultSet = statement.executeQuery();
//                while (resultSet.next()){
//                    user = getUserEntityFromResultSet(resultSet);
//                }
//                return user;
//            } catch (SQLException e) {
//                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
//                throw new DAOException("Unable to get user");
//            }
//        }
//        return user;
//    }

    @Override
    public List<UserEntity> getAll() throws DAOException {
        Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(UserQuery.GET_ALL_USERS_QUERY);
                List<UserEntity> entityList = new ArrayList<>();
                while (resultSet.next()){
                    entityList.add(getUserEntityFromResultSet(resultSet));
                }
                return entityList;
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to retrieve users");
            }
        }
        return Collections.emptyList();
    }

    @Override
    public UserEntity updateEntity(UserEntity userEntity) throws DAOException {
        Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement statement = connection.prepareStatement(UserQuery.UPDATE_USER_BY_ID)) {
                statement.setString(1, userEntity.getName());
                statement.setString(2, userEntity.getSurname());
                statement.setString(3, userEntity.getLogin());
                statement.setString(4, userEntity.getPassword());
                statement.setLong(5, userEntity.getId());
                statement.execute();
                return userEntity;
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to update user");
            }
        }
        return userEntity;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {
        Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 PreparedStatement statement = connection.prepareStatement(UserQuery.DELETE_USER_BY_ID)) {
                statement.setLong(1, id);
                statement.execute();
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to delete user");
            }
        }
    }

    private UserEntity getUserEntityFromResultSet(ResultSet resultSet){
        try {
            final long id = resultSet.getLong(UserEntityFields.ID);
            final String name = resultSet.getString(UserEntityFields.NAME);
            final String surname = resultSet.getString(UserEntityFields.SURNAME);
            final String login = resultSet.getString(UserEntityFields.LOGIN);
            final String password = resultSet.getString(UserEntityFields.PASSWORD);
            final String role = resultSet.getString(UserEntityFields.ROLE_NAME);
            return new UserEntity(id, name, surname, login, password, new RoleEntity(role));
        } catch (SQLException e) {
            LOGGER.error("Failed to convert result set in UserEntity {}", e.getMessage(), e);
            throw new DAOException("Unable to read users", e);
        }
    }
}
