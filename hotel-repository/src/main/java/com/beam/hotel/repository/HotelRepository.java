package com.beam.hotel.repository;

import com.beam.hotel.model.Hotel;

import java.util.Collection;

public interface HotelRepository {

    Collection<Hotel> getHotels(Hotel hotel);
}
