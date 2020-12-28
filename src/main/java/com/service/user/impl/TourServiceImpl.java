package com.service.user.impl;

import com.converter.IConverter;
import com.converter.tour.TourConverter;
import com.dao.entity.tour.TourEntity;
import com.dao.impl.orm.tour.TourOrmDAO;
import com.dao.tour.TourDAO;
import com.service.dto.tours.TourDTO;
import com.service.user.TourService;

import java.util.List;

public class TourServiceImpl implements TourService {
    private TourDAO tourDAO = new TourOrmDAO();
    private IConverter<TourEntity, TourDTO> converter = new TourConverter();

    @Override
    public List<TourDTO> getAllTours() {
        return converter.convertAll(tourDAO.getAll());
    }
}