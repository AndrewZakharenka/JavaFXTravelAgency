package com.dao.impl.orm.user;

import com.dao.entity.role.RoleEntity;
import com.dao.entity.user.UserEntity;
import com.dao.exception.DAOException;
import com.dao.impl.orm.OrmAbstractDAO;
import com.dao.impl.orm.util.HibernateSessionFactoryUtil;
import com.dao.user.UserDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserOrmDAO extends OrmAbstractDAO<UserEntity> implements UserDAO {

    @Override
    public UserEntity getByLogin(String login) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Criteria userCriteria = session.createCriteria(UserEntity.class);
            userCriteria.add(Restrictions.eq("login", login));
            UserEntity userEntity = (UserEntity) userCriteria.uniqueResult();
            return userEntity;
        } catch (Exception e) {
            LOGGER.error("Unable to get entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to get entities: " + e.getMessage(), e);
        }
    }

    @Override
    public UserEntity create(UserEntity entity) throws DAOException {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            entity.setRoleEntity(new RoleEntity(2, "User"));
            session.save(entity);
            transaction.commit();
            return entity;
        }catch (Exception e){
            LOGGER.error("Unable to get entities: {}", e.getMessage(), e);
            throw new DAOException("Unable to get entities: " + e.getMessage(), e);
        }
    }

    @Override
    protected Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    protected String getEntityName(){
        return "UserEntity";
    }
}
