package com.hotel.lodgingCommander.service.impl;

import com.hotel.lodgingCommander.entity.Address;
import com.hotel.lodgingCommander.model.MapDTO;
import com.hotel.lodgingCommander.repository.MapRepository;
import com.hotel.lodgingCommander.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapImpl implements MapService {

    private final MapRepository mapRepository;


    @Autowired
    public MapImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public MapDTO getLocationById(Long id) {
        Address address = mapRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid location Id: " + id));
        return new MapDTO(address.getId(), address.getLatitude(), address.getLongitude());
    }
}