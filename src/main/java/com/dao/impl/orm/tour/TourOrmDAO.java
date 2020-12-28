package com.dao.impl.orm.tour;

import com.dao.DAO;
import com.dao.entity.tour.TourEntity;
import com.dao.impl.orm.OrmAbstractDAO;
import com.dao.tour.TourDAO;

public class TourOrmDAO extends OrmAbstractDAO<TourEntity> implements TourDAO {

    @Override
    protected Class<TourEntity> getEntityClass() {
        return TourEntity.class;
    }

    public String getEntityName(){
        return "TourEntity";
    }

}
