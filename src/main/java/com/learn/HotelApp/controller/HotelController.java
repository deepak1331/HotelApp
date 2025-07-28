package com.learn.HotelApp.controller;

import com.learn.HotelApp.entity.Hotel;
import com.learn.HotelApp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveHotel(hotel));
    }

    @RequestMapping(path = "/{hotelId}", method = RequestMethod.GET)
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(service.getHotelById(hotelId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> getHotels(){
        return ResponseEntity.ok(service.getAllHotel());
    }

    @RequestMapping(path = "/{hotelId}", method = RequestMethod.PUT)
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId, @RequestBody Hotel hotel) {
        return ResponseEntity.ok(service.updateHotel(hotelId, hotel));
    }
}