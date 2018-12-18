package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;
import com.beam.hotel.request.BestHotelRequest;
import com.beam.hotel.response.BestHotelResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

public class BestHotelProvider {

    private static final String REST_URI = "http://localhost:8081/bestHotel";
    private Client client = ClientBuilder.newClient();

    public Collection<Hotel> listHotelsFromProvider(Hotel hotel) {
        BestHotelRequest bestHotelRequest = buildBestHotelRequest(hotel);
        Response response = callService(bestHotelRequest);
        Collection<BestHotelResponse> bestHotelResponses = getBestHotels(response);
        return paresBestHotelToHotel(bestHotelResponses);
    }

    private Collection<Hotel> paresBestHotelToHotel(Collection<BestHotelResponse> bestHotelResponses) {
        Collection<Hotel> hotels = new ArrayList<>();
        bestHotelResponses.forEach(e -> {
            hotels.add(new Hotel.Builder()
                    .provider("Best Hotel")
                    .hotelName(e.getHotel())
                    .rate(e.getHotelRate())
                    .farePerNight(e.getHotelFare())
                    .amenities(e.getRoomAmenities().split(","))
                    .build()
            );
        });
        return hotels;
    }

    private Collection<BestHotelResponse> getBestHotels(Response response) {
        Collection<BestHotelResponse> bestHotels = new ArrayList<>();
        bestHotels = response.readEntity(new GenericType<Collection<BestHotelResponse>>() {});
        return bestHotels;
    }

    private Response callService(BestHotelRequest request) {
        return  client.target(REST_URI)
                .path(request.getFromDate())
                .path(request.getToDate())
                .path(request.getCity())
                .path(String.valueOf(request.getNumberOfAdults()))
                .request(MediaType.APPLICATION_JSON).get();
    }

    private BestHotelRequest    buildBestHotelRequest(Hotel hotel) {
        return new BestHotelRequest.Builder()
                .fromDate(hotel.getFromDate())
                .toDate(hotel.getToDate())
                .city(hotel.getCity())
                .numberOfAdults(hotel.getNumberOfAdults())
                .build();
    }
}
