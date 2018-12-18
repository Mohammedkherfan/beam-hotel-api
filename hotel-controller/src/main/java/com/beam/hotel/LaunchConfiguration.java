package com.beam.hotel;

import com.beam.hotel.configuration.ApiConfiguration;
import com.beam.hotel.configuration.ProviderConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchConfiguration {

    @Bean
    public ApiConfiguration apiConfiguration() {
        return new ApiConfiguration();
    }

    @Bean
    public ProviderConfiguration providerConfiguration() {
        return new ProviderConfiguration();
    }

}
