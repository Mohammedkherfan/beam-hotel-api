package com.beam.hotel.usecase;

import com.beam.hotel.request.GetHotelRequest;
import com.beam.hotel.response.GetHotelResponse;

import java.util.Collection;

public interface GetHotelUseCase {

    Collection<GetHotelResponse> getHotels(GetHotelRequest request);
}
