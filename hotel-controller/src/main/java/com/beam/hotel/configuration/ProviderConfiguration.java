package com.beam.hotel.configuration;

import com.beam.hotel.provider.BestHotelProvider;
import com.beam.hotel.provider.CrazyHotelsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfiguration {

    @Bean
    public CrazyHotelsProvider crazyHotelsProvider() {
        return new CrazyHotelsProvider();
    }

    @Bean
    public BestHotelProvider bestHotelProvider() {
        return new BestHotelProvider();
    }
}
