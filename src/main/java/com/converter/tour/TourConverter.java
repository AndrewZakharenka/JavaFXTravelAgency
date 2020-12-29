package com.converter.tour;

import com.converter.AbstractConverter;
import com.dao.entity.client.ClientEntity;
import com.dao.entity.role.RoleEntity;
import com.dao.entity.tour.TourEntity;
import com.dao.entity.user.UserEntity;
import com.service.dto.clients.ClientDTO;
import com.service.dto.roles.RoleDTO;
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
                                                            new RoleDTO( tourEntity.getUserEntity().getRoleEntity().getId(),
                                                                    tourEntity.getUserEntity().getRoleEntity().getName())),
                                                    new ClientDTO(tourEntity.getClientEntity().getId(),
                                                            tourEntity.getClientEntity().getName(),
                                                            tourEntity.getClientEntity().getSurname(),
                                                            tourEntity.getClientEntity().getSerialPassport(),
                                                            tourEntity.getClientEntity().getNumberPassport(),
                                                            tourEntity.getClientEntity().getAddress()));
    }

    @Override
    public TourEntity convertReverse(TourDTO tourDTO) {
        return new TourEntity(tourDTO.getId(), tourDTO.getDeparture(), tourDTO.getArrive(), tourDTO.getDepartureDate(),
                tourDTO.getArriveDate(), tourDTO.getHotel(), tourDTO.getPrice(),
                    new UserEntity(tourDTO.getUserDTO().getId(), tourDTO.getUserDTO().getName(),
                            tourDTO.getUserDTO().getSurname(), tourDTO.getUserDTO().getLogin(),
                            tourDTO.getUserDTO().getPassword(), new RoleEntity(tourDTO.getUserDTO().getRoleDTO().getId(),
                            tourDTO.getUserDTO().getRoleDTO().getName())),
                new ClientEntity(tourDTO.getClientDTO().getId(), tourDTO.getClientDTO().getName(),
                        tourDTO.getClientDTO().getSurname(), tourDTO.getClientDTO().getSerialPassport(),
                        tourDTO.getClientDTO().getNumberPassport(), tourDTO.getClientDTO().getAddress()));
    }
}
