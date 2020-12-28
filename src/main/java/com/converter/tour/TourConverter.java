package com.converter.tour;

import com.converter.AbstractConverter;
import com.dao.entity.tour.TourEntity;
import com.service.dto.clients.ClientDTO;
import com.service.dto.tours.TourDTO;
import com.service.dto.user.UserDTO;

public class TourConverter extends AbstractConverter<TourEntity, TourDTO> {
    @Override
    public TourDTO convert(TourEntity tourEntity) {
        return new TourDTO(tourEntity.getId(), tourEntity.getDeparture(),tourEntity.getArrive(),
                            tourEntity.getDepartureDate(),tourEntity.getArriveDate(),tourEntity.getHotel(),
                            tourEntity.getPrice(), new UserDTO(tourEntity.getUserEntity().getId(),
                                                            tourEntity.getUserEntity().getName(),
                                                            tourEntity.getUserEntity().getSurname(),
                                                            tourEntity.getUserEntity().getLogin(),
                                                            tourEntity.getUserEntity().getPassword(),
                                                            tourEntity.getUserEntity().getRoleEntity().getName()),
                                                    new ClientDTO(tourEntity.getClientEntity().getId(),
                                                            tourEntity.getClientEntity().getName(),
                                                            tourEntity.getClientEntity().getSurname(),
                                                            tourEntity.getClientEntity().getSerialPassport(),
                                                            tourEntity.getClientEntity().getNumberPassport(),
                                                            tourEntity.getClientEntity().getAddress()));
    }

    @Override
    public TourEntity convertReverse(TourDTO tourDTO) {
        return null;
    }
}
