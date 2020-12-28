package com.dao.impl.orm.util;

import com.dao.entity.role.RoleEntity;
import com.dao.entity.user.UserEntity;
import com.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateSessionFactoryUtil implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(HibernateSessionFactoryUtil.class);
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(UserEntity.class);
                configuration.addAnnotatedClass(RoleEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                LOGGER.error("Unable to get session: {}", e.getMessage(), e);
                throw new DAOException("Unable to get session: " + e.getMessage(), e);
            }
        }
        return sessionFactory;
    }

    @Override
    public void close() throws Exception {

    }
}
