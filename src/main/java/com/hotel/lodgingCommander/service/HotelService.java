package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.hotel.HotelResponseDTO;
import com.hotel.lodgingCommander.model.MapDTO;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {
    HotelResponseDTO getHotelById(Long id);

    MapDTO getAddressByHotelId(Long hotelId);

    List<HotelResponseDTO> findAvailableHotels(String location, LocalDate checkInDate, LocalDate checkOutDate, int adjustedGuests, int rooms);

    Object findByLocation(String location);

    Object getRecentHotels();
}
