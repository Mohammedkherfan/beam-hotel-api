package com.beam.hotel.service;

import com.beam.hotel.exception.HotelException;
import com.beam.hotel.repository.HotelRepository;
import com.beam.hotel.request.GetHotelRequest;
import com.beam.hotel.response.GetHotelResponse;
import com.beam.hotel.usecase.GetHotelUseCase;
import com.beam.hotel.usecase.GetHotelUseCaseImp;
import com.beam.hotel.validation.HotelValidation;

import java.util.Collection;

public class HotelServiceImp implements HotelService {

    private GetHotelUseCase getHotelUseCase;
    private HotelValidation validation = new HotelValidation();

    public HotelServiceImp(HotelRepository repository) {
        this.getHotelUseCase = new GetHotelUseCaseImp(repository);
    }

    @Override
    public Collection<GetHotelResponse> getHotels(GetHotelRequest request) throws HotelException {
        validation.getHotelsRequestValidation(request);
        return getHotelUseCase.getHotels(request);
    }
}
