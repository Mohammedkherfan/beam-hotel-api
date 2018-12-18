package com.beam.hotel.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BestHotelResponse {

    private String hotel;
    private Float hotelRate;
    private String hotelFare;
    private String roomAmenities;

    public BestHotelResponse() {
    }

    public BestHotelResponse(String hotel, Float hotelRate, String hotelFare, String roomAmenities) {
        this.hotel = hotel;
        this.hotelRate = hotelRate;
        this.hotelFare = hotelFare;
        this.roomAmenities = roomAmenities;
    }

    public String getHotel() {
        return hotel;
    }

    public Float getHotelRate() {
        return hotelRate;
    }

    public String getHotelFare() {
        return hotelFare;
    }

    public String getRoomAmenities() {
        return roomAmenities;
    }
}
