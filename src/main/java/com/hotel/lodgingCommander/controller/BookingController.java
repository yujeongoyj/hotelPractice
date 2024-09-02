package com.hotel.lodgingCommander.controller;

import com.hotel.lodgingCommander.dto.bookingList.BookingListRequestDTO;
import com.hotel.lodgingCommander.dto.room.RoomResponseDTO;
import com.hotel.lodgingCommander.service.BookingService;
import com.hotel.lodgingCommander.service.impl.CartImpl;
import com.hotel.lodgingCommander.service.impl.FacilityImpl;
import com.hotel.lodgingCommander.service.impl.RoomImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class BookingController {

    private  final BookingService bookingService;
    private final RoomImpl ROOM_SERVICE;
    private final FacilityImpl FACILITY_SERVICE;
    private final CartImpl CART_SERVICE;



    @RequestMapping("/booking/{id}")
    public ResponseEntity<Map<String, Object>> responseBooking(@PathVariable("id") Long roomId) {
        Map<String, Object> map = new HashMap<>();
        RoomResponseDTO roomResponseDTO = ROOM_SERVICE.selectOneRoom(roomId);
        map.put("RoomResponseDTO", roomResponseDTO);
        map.put("FacilityList", FACILITY_SERVICE.getList(roomResponseDTO.getHotelId()));
        return ResponseEntity.ok(map);
    }

    @PostMapping("/booking/{id}")
    public void requestBooking(@PathVariable Long id, @RequestBody BookingListRequestDTO requestDTO) {
        try {
            bookingService.createBooking(requestDTO);
            if (requestDTO.getCartId() != null) {
                CART_SERVICE.delete(requestDTO.getCartId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/booking/cancel/{id}")
    public void updateBooking(@PathVariable("id") Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @RequestMapping("/validBooking/{id}")
    public ResponseEntity<Map<String, Object>> validBooking(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(bookingService.myAllValidBooking(userId));
    }

    @RequestMapping("/expiredBooking/{id}")
    public ResponseEntity<Map<String, Object>> expiredBooking(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(bookingService.myAllExpiredBooking(userId));
    }

    @RequestMapping("/cancelBooking/{id}")
    public ResponseEntity<Map<String, Object>> cancelBooking(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(bookingService.myAllCancelBooking(userId));
    }

}
