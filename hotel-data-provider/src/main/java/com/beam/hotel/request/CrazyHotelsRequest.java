package com.beam.hotel.request;

public class CrazyHotelsRequest {

    private String from;
    private String to;
    private String city;
    private Integer adultsCount;

    public CrazyHotelsRequest() {
    }

    public CrazyHotelsRequest(String from, String to, String city, Integer adultsCount) {
        this.from = from;
        this.to = to;
        this.city = city;
        this.adultsCount = adultsCount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getCity() {
        return city;
    }

    public Integer getAdultsCount() {
        return adultsCount;
    }

    public static class Builder {

        private String from;
        private String to;
        private String city;
        private Integer adultsCount;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder adultsCount(Integer adultsCount) {
            this.adultsCount = adultsCount;
            return this;
        }

        public CrazyHotelsRequest build() {
            return new CrazyHotelsRequest(from, to, city, adultsCount);
        }
    }
}
