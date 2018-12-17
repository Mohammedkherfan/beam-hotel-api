package com.beam.hotel.service;

import com.beam.hotel.request.GetHotelRequest;
import com.beam.hotel.response.GetHotelResponse;

import java.util.Collection;

public interface HotelService {

    Collection<GetHotelResponse> getHotels(GetHotelRequest request);
 }
