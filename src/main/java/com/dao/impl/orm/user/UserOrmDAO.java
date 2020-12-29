package com.dao.impl.orm.user;

import com.dao.entity.role.RoleEntity;
import com.dao.entity.user.UserEntity;
import com.dao.exception.DAOException;
import com.dao.impl.orm.OrmAbstractDAO;
import com.dao.user.UserDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

public class UserOrmDAO extends OrmAbstractDAO<UserEntity> implements UserDAO {

    @Override
    public UserEntity getByLogin(String login) {
        try(Session session = SESSION_FACTORY_PROVIDER.getSessionFactory().openSession()){
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
        try(Session session = SESSION_FACTORY_PROVIDER.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(RoleEntity.class).
                    add(Restrictions.eq("name", entity.getRoleEntity().getName()));
            ArrayList<RoleEntity> roleEntities = (ArrayList<RoleEntity>) criteria.list();
            entity.setRoleEntity(roleEntities.get(0));
//            entity.setRoleEntity(new RoleEntity(2, "User"));
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

}
