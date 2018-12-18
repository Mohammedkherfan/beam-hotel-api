package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;
import com.beam.hotel.request.CrazyHotelsRequest;
import com.beam.hotel.response.CrazyHotelsResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class CrazyHotelsProvider {

    private static final String REST_URI = "http://localhost:8082/crazyHotel";
    private Client client = ClientBuilder.newClient();

    public Collection<Hotel> listHotelsFromProvider(Hotel hotel) {
        CrazyHotelsRequest crazyHotelsRequest = buildCrazyHotelRequest(hotel);
        Response response = callService(crazyHotelsRequest);
        Collection<CrazyHotelsResponse> crazyHotelsResponses = getCrazyHotels(response);
        return paresCrazyHotelToHotel(crazyHotelsResponses);
    }

    private Collection<Hotel> paresCrazyHotelToHotel(Collection<CrazyHotelsResponse> crazyHotelsResponses) {
        Collection<Hotel> hotels = new ArrayList<>();
        crazyHotelsResponses.forEach(e -> {
            hotels.add(new Hotel.Builder()
                    .provider("Crazy Hotel")
                    .hotelName(e.getHotelName())
                    .rate(getRate(e.getRate()))
                    .farePerNight(e.getPrice())
                    .discount(e.getDiscount())
                    .amenities(e.getAmenities())
                    .build()
            );
        });
        return hotels;
    }

    private Float getRate(String rate) {
        String[] split = rate.split(",");
        return new Float(split[0].length());
    }

    private Collection<CrazyHotelsResponse> getCrazyHotels(Response response) {
        Collection<CrazyHotelsResponse> bestHotels;
        bestHotels = response.readEntity(new GenericType<Collection<CrazyHotelsResponse>>() {});
        return bestHotels;
    }

    private Response callService(CrazyHotelsRequest request) {
        return client.target(REST_URI)
                .path(request.getFrom())
                .path(request.getTo())
                .path(request.getCity())
                .queryParam(String.valueOf(request.getAdultsCount()))
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    private CrazyHotelsRequest buildCrazyHotelRequest(Hotel hotel) {
        return new CrazyHotelsRequest.Builder()
                .from(ZonedDateTime.parse(hotel.getFromDate()).format(DateTimeFormatter.ISO_INSTANT))
                .to(ZonedDateTime.parse(hotel.getToDate()).format(DateTimeFormatter.ISO_INSTANT))
                .city(hotel.getCity())
                .adultsCount(hotel.getNumberOfAdults())
                .build();
    }


}
