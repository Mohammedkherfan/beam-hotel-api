package com.beam.hotel.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BestHotelRequest {

    private String fromDate;
    private String toDate;
    private String city;
    private Integer numberOfAdults;

    public BestHotelRequest() {
    }

    public BestHotelRequest(String fromDate, String toDate, String city, Integer numberOfAdults) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.city = city;
        this.numberOfAdults = numberOfAdults;
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

    public static class Builder {

        private String fromDate;
        private String toDate;
        private String city;
        private Integer numberOfAdults;

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

        public BestHotelRequest build() {
            return new BestHotelRequest(fromDate, toDate, city, numberOfAdults);
        }
    }
}
