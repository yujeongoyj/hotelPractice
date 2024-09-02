package com.hotel.lodgingCommander.service;

import com.hotel.lodgingCommander.dto.*;
import com.hotel.lodgingCommander.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface FaciltiyService {

    Map<String, Boolean> getList(Long hotelId);
}
