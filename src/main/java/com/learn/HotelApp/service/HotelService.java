package com.learn.HotelApp.service;

import com.learn.HotelApp.entity.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel saveHotel(Hotel hotel);

    public Hotel getHotelById(String hotelId);

    public List<Hotel> getAllHotel();

    public Hotel updateHotel(String hotelId, Hotel hotel);
}
