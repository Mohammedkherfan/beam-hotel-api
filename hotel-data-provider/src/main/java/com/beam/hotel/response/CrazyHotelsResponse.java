package com.beam.hotel.response;

public class CrazyHotelsResponse {

    private String hotelName;
    private String rate;
    private String price;
    private Integer discount;
    private String [] amenities;

    public CrazyHotelsResponse() {
    }

    public CrazyHotelsResponse(String hotelName, String rate, String price, Integer discount, String[] amenities) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.price = price;
        this.discount = discount;
        this.amenities = amenities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRate() {
        return rate;
    }

    public String getPrice() {
        return price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String[] getAmenities() {
        return amenities;
    }
}
