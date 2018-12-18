package com.beam.hotel.test;

import com.beam.hotel.controller.HotelController;
import com.beam.hotel.controller.HotelControllerImp;
import com.beam.hotel.provider.BestHotelProvider;
import com.beam.hotel.provider.CrazyHotelsProvider;
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
public class HotelTestConfiguration {

    @Bean
    public HotelService getHotelService(HotelRepository repository) {
        return new HotelServiceImp(repository);
    }

    @Bean
    public HotelRepository getHotelRepository(@Autowired List<HotelDataProvider> dataProviders) {
        return new HotelProvider(dataProviders);
    }

    @Bean
    public CrazyHotelsProvider crazyHotelsProvider() {
        return new CrazyHotelsProvider();
    }

    @Bean
    public BestHotelProvider bestHotelProvider() {
        return new BestHotelProvider();
    }

    @Bean
    public HotelController getHotelController() {
        return new HotelControllerImp();
    }

}
