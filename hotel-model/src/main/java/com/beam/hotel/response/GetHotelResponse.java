package com.beam.hotel.response;

import java.math.BigDecimal;

public class GetHotelResponse {

    private String provider;
    private String hotelName;
    private BigDecimal fare;
    private String [] amenities;

    public GetHotelResponse() {
    }

    public GetHotelResponse(String provider, String hotelName, BigDecimal fare, String[] amenities) {
        this.provider = provider;
        this.hotelName = hotelName;
        this.fare = fare;
        this.amenities = amenities;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String[] getAmenities() {
        return amenities;
    }

    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }
}
