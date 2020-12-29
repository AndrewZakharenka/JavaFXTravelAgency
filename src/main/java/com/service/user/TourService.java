package com.service.user;


import com.service.dto.tours.TourDTO;

import java.util.List;

public interface TourService {
    List<TourDTO> getAllTours();
    TourDTO createTour(TourDTO tourDTO);
    TourDTO getTourById(long id);
    void deleteTourById(long id);
}
