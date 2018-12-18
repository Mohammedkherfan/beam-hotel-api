package com.beam.hotel;

import com.beam.hotel.gateway.HotelGateway;
import com.beam.hotel.provider.HotelProvider;
import com.beam.hotel.repository.HotelRepository;
import com.beam.hotel.service.HotelService;
import com.beam.hotel.service.HotelServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchConfiguration {

    @Bean
    public HotelService getHotelService() {
        return new HotelServiceImp(getHotelRepository());
    }

    @Bean
    public HotelRepository getHotelRepository() {
        return new HotelProvider();
    }

    @Bean
    public HotelGateway getHotelGateway() {
        return new HotelGateway();
    }
}
