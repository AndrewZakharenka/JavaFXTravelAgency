package com.dao;

import com.dao.entity.IEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDAO<E extends IEntity> implements DAO<E> {
    protected static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);
}
