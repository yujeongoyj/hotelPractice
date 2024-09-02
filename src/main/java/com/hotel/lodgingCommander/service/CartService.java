package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.cart.CartRequestDTO;
import com.hotel.lodgingCommander.dto.cart.CartResponseDTO;
import com.hotel.lodgingCommander.entity.Cart;

import java.util.List;

public interface CartService {
    List<CartResponseDTO> getCartsByUserId(Long userId);

    Boolean delete(Long id);

    Cart insert(CartRequestDTO requestDTO);
}
