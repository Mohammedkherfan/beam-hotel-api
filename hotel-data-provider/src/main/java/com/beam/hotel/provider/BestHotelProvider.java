package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;
import com.beam.hotel.request.BestHotelRequest;
import com.beam.hotel.response.BestHotelResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.isNull;

public class BestHotelProvider implements HotelDataProvider {

    private static final String REST_URI = "http://localhost:8081/bestHotel";
    private Client client = ClientBuilder.newClient();

    @Override
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
        if (isNull(response)) return new ArrayList<>();
        return response.readEntity(new GenericType<Collection<BestHotelResponse>>() {});
    }

    private Response callService(BestHotelRequest request) {
        WebTarget webTarget = client.target(REST_URI)
                .path(request.getFromDate())
                .path(request.getToDate())
                .path(request.getCity())
                .path(String.valueOf(request.getNumberOfAdults()));
        Invocation.Builder invocationBuilder =  webTarget.request("application/hal+json");
        Response response = null;
        try {
            response = invocationBuilder.get();
        }catch (Exception ex) {
            System.out.println("Best Provider Connection Error:" + ex.getMessage());
        }
        return response;
    }

    private BestHotelRequest buildBestHotelRequest(Hotel hotel) {
        return new BestHotelRequest.Builder()
                .fromDate(hotel.getFromDate())
                .toDate(hotel.getToDate())
                .city(hotel.getCity())
                .numberOfAdults(hotel.getNumberOfAdults())
                .build();
    }
}
