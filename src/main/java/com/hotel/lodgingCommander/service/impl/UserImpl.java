package com.hotel.lodgingCommander.service.impl;
import com.hotel.lodgingCommander.dto.user.UserDTO;
import com.hotel.lodgingCommander.entity.User;
import com.hotel.lodgingCommander.repository.UserRepository;
import com.hotel.lodgingCommander.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UserImpl implements UserService {
    private final UserRepository USER_REPOSITORY;
    private final BCryptPasswordEncoder passwordEncoder;

    private final int SILVER_THRESHOLD = 5;
    private final int GOLD_THRESHOLD = 15;
    private final int VIP_THRESHOLD = 30;

    @Autowired
    public UserImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        USER_REPOSITORY = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Boolean registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        USER_REPOSITORY.save(user);
        return true;
    }
    @Override
    public Optional<User> getUserInfo(String email) {
        return USER_REPOSITORY.findByEmail(email);
    }

    @Override
    public Boolean update(String email, User user) {
        Optional<User> existingUserOpt = USER_REPOSITORY.findByEmail(email);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            if (user.getTel() != null && !user.getTel().isEmpty()) {
                existingUser.setTel(user.getTel());
            }
            if (user.getNickname() != null && !user.getNickname().isEmpty()) {
                existingUser.setNickname(user.getNickname());
            }
            USER_REPOSITORY.save(existingUser);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(String email) {
        USER_REPOSITORY.deleteByEmail(email);
        return true;
    }

    public UserDTO getUserDTO(String email) {
        Optional<User> user = USER_REPOSITORY.findByEmail(email);
        return new UserDTO(user.orElse(null));
    }

    @Override
    public User getUserById(Long userId) {
        return USER_REPOSITORY.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }
    @Override
    public Boolean emailExists(String email) {
        return USER_REPOSITORY.existsByEmail(email);
    }


}
