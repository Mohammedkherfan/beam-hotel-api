package com.beam.hotel.usecase;

import com.beam.hotel.exception.HotelException;
import com.beam.hotel.model.Hotel;
import com.beam.hotel.repository.HotelRepository;
import com.beam.hotel.request.GetHotelRequest;
import com.beam.hotel.response.GetHotelResponse;

import java.util.ArrayList;
import java.util.Collection;

public class GetHotelUseCaseImp implements GetHotelUseCase {

    private HotelRepository repository;

    public GetHotelUseCaseImp(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<GetHotelResponse> getHotels(GetHotelRequest request) throws HotelException{
        Collection<GetHotelResponse> hotels = new ArrayList<>();
        repository.getHotels(buildHotelFilter(request)).forEach(e -> {
            hotels.add(new GetHotelResponse(e.getProvider(), e.getHotelName(), e.getFarePerNight(), e.getAmenities()));
        });
        return hotels;
    }

    private Hotel buildHotelFilter(GetHotelRequest request) {
        return new Hotel.Builder()
                .fromDate(request.getFromDate())
                .toDate(request.getToDate())
                .city(request.getCity())
                .numberOfAdults(request.getNumberOfAdults())
                .build();
    }
}
