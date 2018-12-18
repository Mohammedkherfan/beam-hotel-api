package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;

import java.util.Collection;

public interface HotelDataProvider {

    Collection<Hotel> listHotelsFromProvider(Hotel hotel);
}
