package com.beam.hotel.gateway;

import com.beam.hotel.request.GetHotelRequest;
import com.beam.hotel.response.GetHotelResponse;
import com.beam.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class HotelGateway {

    @Autowired
    private HotelService service;

    public Collection<GetHotelResponse> getHotels(GetHotelRequest request) {
        return service.getHotels(request);
    }
}
