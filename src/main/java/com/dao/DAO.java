package com.dao;

import com.dao.entity.IEntity;
import com.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface DAO<E extends IEntity> {
    E create(E entity) throws DAOException;
    Optional<E> getEntity(long id) throws DAOException;
    List<E> getAll() throws DAOException;
    E updateEntity(E entity) throws DAOException;
    void deleteEntity(Long id) throws DAOException;
}
