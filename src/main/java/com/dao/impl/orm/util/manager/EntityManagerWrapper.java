package com.dao.impl.orm.util.manager;

import javax.persistence.EntityManager;

public class EntityManagerWrapper implements AutoCloseable {

    private EntityManager entityManager;

    public EntityManagerWrapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void close() throws Exception {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
