package com.dao.impl.orm.provider;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SessionFactoryProvider {

    private static final Lock LOCK = new ReentrantLock();
    private SessionFactory sessionFactory ;
    private StandardServiceRegistry registry;

    private SessionFactoryProvider() {}

    private static class SessionFactoryHolder {
        private static final SessionFactoryProvider INSTANCE = new SessionFactoryProvider();
    }

    public static SessionFactoryProvider getInstance() {
        return SessionFactoryHolder.INSTANCE;
    }

    public void init() {
        if (this.sessionFactory == null) {
            try {
                LOCK.lock();
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } finally {
                LOCK.unlock();
            }
        }
    }

    public void destroy() {
        if (this.sessionFactory == null) {
            try {
                LOCK.lock();
                StandardServiceRegistryBuilder.destroy(registry);
            } finally {
                LOCK.unlock();
            }
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
