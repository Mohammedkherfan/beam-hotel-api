package com.beam.hotel.request;

public class GetHotelRequest {

    private String fromDate;
    private String toDate;
    private String city;
    private Integer numberOfAdults;

    public GetHotelRequest() {
    }

    public GetHotelRequest(String fromDate, String toDate, String city, Integer numberOfAdults) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.city = city;
        this.numberOfAdults = numberOfAdults;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
