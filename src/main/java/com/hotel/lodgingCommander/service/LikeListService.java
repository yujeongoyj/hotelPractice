package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.model.LikeListDTO;

import java.util.List;

public interface LikeListService {
    Boolean addLike(LikeListDTO likeListDTO);

    Boolean removeLike(LikeListDTO likeListDTO);

    List<LikeListDTO> getLikesByUserId(long userId);

    LikeListDTO findByUserIdAndHotelId(Long userId, Long hotelId);

    Boolean removeLikeById(Long id);
}
