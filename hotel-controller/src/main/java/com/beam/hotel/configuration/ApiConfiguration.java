package com.beam.hotel.configuration;

import com.beam.hotel.provider.HotelDataProvider;
import com.beam.hotel.provider.HotelProvider;
import com.beam.hotel.repository.HotelRepository;
import com.beam.hotel.service.HotelService;
import com.beam.hotel.service.HotelServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiConfiguration {

    @Bean
    public HotelService getHotelService(HotelRepository repository) {
        return new HotelServiceImp(repository);
    }

    @Bean
    public HotelRepository getHotelRepository(@Autowired List<HotelDataProvider> dataProviders) {
        return new HotelProvider(dataProviders);
    }
}
