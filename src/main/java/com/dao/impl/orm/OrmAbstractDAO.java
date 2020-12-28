package com.dao.impl.orm;

import com.dao.AbstractDAO;
import com.dao.entity.IEntity;
import com.dao.exception.DAOException;
import com.dao.impl.orm.provider.EntityManagerFactoryProvider;
import com.dao.impl.orm.util.HibernateSessionFactoryUtil;
import com.dao.impl.orm.util.manager.EntityManagerWrapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public abstract class OrmAbstractDAO<E extends IEntity>  extends AbstractDAO<E> {

    private static final EntityManagerFactoryProvider ENTITY_MANAGER_FACTORY_PROVIDER = EntityManagerFactoryProvider.getInstance();

    @Override
    public E create(E entity) throws DAOException {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return entity;
        }catch (Exception e){
            LOGGER.error("Unable to get entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to get entities: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<E> getEntity(long id) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            return Optional.ofNullable(entityManager.find(getEntityClass(), id));
        }catch (Exception e){
            LOGGER.error("Unable to get entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to get entities: " + e.getMessage(), e);
        }
    }

    @Override
    public List<E> getAll() throws DAOException {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return (List<E>) session.createQuery("From " + getEntityClass().getSimpleName()).list();
        }catch (Exception e){
            LOGGER.error("Unable to get entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to get entities: " + e.getMessage(), e);
        }
    }

    @Override
    public E updateEntity(E entity) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            return entityManager.merge(entity);
        }catch (Exception e){
            LOGGER.error("Unable to update entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to update entities: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {
        try(EntityManagerWrapper entityManagerWrapper = getEntityManagerWrapper()) {
            EntityManager entityManager = entityManagerWrapper.getEntityManager();
            Optional<E> entityOptional = getEntity(id);
            entityOptional.ifPresent(entityManager::remove);
        } catch (Exception e) {
            LOGGER.error("Unable to delete entity: {}", e.getMessage(), e);
            throw new DAOException("Unable to delete entity: " + e.getMessage(), e);
        }
    }

    protected abstract Class<E> getEntityClass();

    protected abstract String getEntityName();

    protected EntityManagerWrapper getEntityManagerWrapper() {
        return new EntityManagerWrapper(ENTITY_MANAGER_FACTORY_PROVIDER.getEntityManagerFactory().createEntityManager());
    }
}
