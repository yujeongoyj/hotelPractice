package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.room.RoomResponseDTO;
import com.hotel.lodgingCommander.entity.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface RoomService {

    List<RoomResponseDTO> getRoomsWithBookingStatus(Long hotelId, LocalDate checkInDate, LocalDate checkOutDate);
    RoomResponseDTO selectOneRoom(Long id);

}
