package com.beam.hotel.controller;

import com.beam.hotel.response.GetHotelResponse;
import org.springframework.hateoas.Resource;

import java.util.Collection;

public interface HotelController {

    Collection<Resource<GetHotelResponse>> getHotels(String fromDate, String toDate, String city, Integer numberOfAdults);
}
