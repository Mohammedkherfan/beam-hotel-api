package com.beam.hotel.model;

import java.math.BigDecimal;

public class Hotel {

    private String fromDate;
    private String toDate;
    private String city;
    private Integer numberOfAdults;
    private String provider;
    private String hotelName;
    private BigDecimal fare;
    private String [] amenities;

    public Hotel() {
    }

    public Hotel(String fromDate, String toDate, String city, Integer numberOfAdults, String provider, String hotelName, BigDecimal fare, String[] amenities) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.city = city;
        this.numberOfAdults = numberOfAdults;
        this.provider = provider;
        this.hotelName = hotelName;
        this.fare = fare;
        this.amenities = amenities;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getCity() {
        return city;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public String getProvider() {
        return provider;
    }

    public String getHotelName() {
        return hotelName;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public String[] getAmenities() {
        return amenities;
    }

    public static class Builder {

        private String fromDate;
        private String toDate;
        private String city;
        private Integer numberOfAdults;
        private String provider;
        private String hotelName;
        private BigDecimal fare;
        private String [] amenities;

        public Builder fromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder toDate(String toDate) {
            this.toDate = toDate;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder numberOfAdults(Integer numberOfAdults) {
            this.numberOfAdults = numberOfAdults;
            return this;
        }

        public Builder provider(String provider) {
            this.provider = provider;
            return this;
        }

        public Builder hotelName(String hotelName) {
            this.hotelName = hotelName;
            return this;
        }

        public Builder fare(BigDecimal fare) {
            this.fare = fare;
            return this;
        }

        public Builder amenities(String [] amenities) {
            this.amenities = amenities;
            return this;
        }

        public Hotel build() {
            return new Hotel(fromDate, toDate, city, numberOfAdults, provider, hotelName, fare, amenities);
        }
    }
}
