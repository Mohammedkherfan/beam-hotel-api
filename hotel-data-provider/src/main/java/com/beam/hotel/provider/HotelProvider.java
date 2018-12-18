package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;
import com.beam.hotel.repository.HotelRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HotelProvider implements HotelRepository {

    private final List<HotelDataProvider> providers;

    public HotelProvider(List<HotelDataProvider> providers) {
        this.providers = providers;
    }

    @Override
    public Collection<Hotel> getHotels(Hotel hotel) {
        Collection<Hotel> hotels = new ArrayList<>();
        providers.stream().map(p -> p.listHotelsFromProvider(hotel)).forEach(hotels::addAll);
        return hotels;
    }
}
