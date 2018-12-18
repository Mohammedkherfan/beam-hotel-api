package com.beam.hotel.provider;

import com.beam.hotel.model.Hotel;
import com.beam.hotel.request.CrazyHotelsRequest;
import com.beam.hotel.response.CrazyHotelsResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.isNull;

public class CrazyHotelsProvider implements HotelDataProvider{

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
        if (isNull(response)) return new ArrayList<>();
        return response.readEntity(new GenericType<Collection<CrazyHotelsResponse>>() {});
    }

    private Response callService(CrazyHotelsRequest request) {
        WebTarget webTarget = client.target(REST_URI)
                .path(request.getFrom())
                .path(request.getTo())
                .path(request.getCity())
                .path(String.valueOf(request.getAdultsCount()));
        Invocation.Builder invocationBuilder =  webTarget.request("application/hal+json");
        Response response = null;
        try {
            response = invocationBuilder.get();
        }catch (Exception ex) {
            System.out.println("Crazy Provider Connection Error:" + ex.getMessage());
        }
        return response;
    }

    private CrazyHotelsRequest buildCrazyHotelRequest(Hotel hotel) {
        return new CrazyHotelsRequest.Builder()
                .from(String.valueOf(ZonedDateTime.parse(hotel.getFromDate()+"T00:00:00.000Z").format(DateTimeFormatter.ISO_INSTANT)))
                .to(String.valueOf(ZonedDateTime.parse(hotel.getToDate()+"T00:00:00.000Z").format(DateTimeFormatter.ISO_INSTANT)))
                .city(hotel.getCity())
                .adultsCount(hotel.getNumberOfAdults())
                .build();
    }


}
