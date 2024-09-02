package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.*;
import com.hotel.lodgingCommander.dto.bookingList.BookingListRequestDTO;
import com.hotel.lodgingCommander.entity.BookingList;
import com.hotel.lodgingCommander.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface BookingService {

    BookingList createBooking(BookingListRequestDTO requestDTO);

    Boolean cancelBooking(Long bookingId);

    Map<String, Object> myAllValidBooking(Long userId);

    Map<String, Object> myAllExpiredBooking(Long userId);

    Map<String, Object> myAllCancelBooking(Long userId);
}
