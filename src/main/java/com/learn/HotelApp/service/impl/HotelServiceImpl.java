package com.learn.HotelApp.service.impl;

import com.learn.HotelApp.entity.Hotel;
import com.learn.HotelApp.exception.ResourceNotFoundException;
import com.learn.HotelApp.repo.HotelRepository;
import com.learn.HotelApp.service.HotelService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        log.info("Saving Hotel : {}", hotel);
        String uuid = UUID.randomUUID().toString();
        hotel.setId(uuid);
        Hotel result = repository.save(hotel);
        log.debug("Record saved: {}", result);
        return result;
    }

    @Override
    public List<Hotel> getAllHotel() {
        log.info("Fetching All Hotels");
        List<Hotel> result = repository.findAll();
        log.debug("Total Records found : {}, Data : {}", result.size(), result);
        return result;
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        log.info("Fetching Hotel with ID: {}", hotelId);
        Hotel existingHotel = repository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("Records not found for ID: " + hotelId));

        if(hotel.getName()!=null)
            existingHotel.setName(hotel.getName());
        if(hotel.getAbout()!=null)
            existingHotel.setAbout(hotel.getAbout());
        if(hotel.getLocation()!=null)
            existingHotel.setLocation(hotel.getLocation());

        return repository.save(existingHotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        log.info("Fetching Hotel with ID: {}", hotelId);
        Hotel result = repository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("Records not found for ID: " + hotelId));

        log.debug("Records found for ID : {}, Data : {}", hotelId, result);
        return result;
    }
}
