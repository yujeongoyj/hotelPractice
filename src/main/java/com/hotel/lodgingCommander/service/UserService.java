package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.user.UserDTO;
import com.hotel.lodgingCommander.entity.User;

import java.util.Optional;

public interface UserService {
    Boolean registerUser(User entity);

    Boolean update(String email, User entity);

    User getUserById(Long id);

    Boolean delete(String email);

    Optional<User> getUserInfo(String email);

    UserDTO getUserDTO(String email);

    Boolean emailExists(String email);
}
