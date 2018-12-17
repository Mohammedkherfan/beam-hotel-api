package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;
import com.beam.hotel.repository.HotelRepository;

import java.util.Collection;

public class HotelProvider implements HotelRepository {

    @Override
    public Collection<Hotel> getHotels(Hotel hotel) {
        return null;
    }
}
