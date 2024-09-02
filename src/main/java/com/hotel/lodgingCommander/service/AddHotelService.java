package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.*;
import com.hotel.lodgingCommander.entity.Facility;
import com.hotel.lodgingCommander.entity.Room;
import com.hotel.lodgingCommander.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public interface AddHotelService {

    Long saveAddress(AddressDTO addressDTO);
    List<CategoryDTO> getAllCategories();
    Long saveCategory(CategoryDTO categoryDTO);
    Long saveHotel(HotelDTO hotelDTO, User user);
    Facility saveFacility(FacilityDTO facilityDTO);
    Room saveRoom(RoomDTO roomDTO);
    Long saveImage(MultipartFile file) throws IOException;
    List<HotelDTO> getHotelsByUserId(Long userId);
}
