package com.beam.hotel.test;

import com.beam.hotel.request.BestHotelRequest;
import com.beam.hotel.request.CrazyHotelsRequest;
import com.beam.hotel.response.BestHotelResponse;
import com.beam.hotel.response.CrazyHotelsResponse;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class DataProviderTest {

    private String bestHotelUrl = "http://localhost:8081/bestHotel";
    private String crazyHotelUrl = "http://localhost:8082/crazyHotel";
    private Client client;
    private BestHotelRequest bestHotelRequest;
    private CrazyHotelsRequest crazyHotelsRequest;

    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newClient();
        bestHotelRequest = new BestHotelRequest.Builder()
                .fromDate("2019-02-01")
                .toDate("2019-02-10")
                .city("AUH")
                .numberOfAdults(1)
                .build();
        crazyHotelsRequest = new CrazyHotelsRequest.Builder()
                .from("2019-02-01T00:00:00.000Z")
                .to("2019-02-10T00:00:00.000Z")
                .city("AUH")
                .adultsCount(1)
                .build();
    }

    @Test
    public void whenCallBestHotelProvider_AndProviderAlreadyRun_ThenShouldReturnListOfData() {
        WebTarget webTarget = client.target(bestHotelUrl)
                .path(bestHotelRequest.getFromDate())
                .path(bestHotelRequest.getToDate())
                .path(bestHotelRequest.getCity())
                .path(String.valueOf(bestHotelRequest.getNumberOfAdults()));
        Invocation.Builder invocationBuilder =  webTarget.request("application/hal+json");
        Collection<BestHotelResponse> bestHotelResponses = invocationBuilder.get().readEntity(new GenericType<Collection<BestHotelResponse>>() {});
        assertTrue(!bestHotelResponses.isEmpty());
    }

    @Test
    public void whenCallCrazyHotelProvider_AndProviderAlreadyRun_ThenShouldReturnListOfData() {
        WebTarget webTarget = client.target(crazyHotelUrl)
                .path(crazyHotelsRequest.getFrom())
                .path(crazyHotelsRequest.getTo())
                .path(crazyHotelsRequest.getCity())
                .path(String.valueOf(crazyHotelsRequest.getAdultsCount()));
        Invocation.Builder invocationBuilder =  webTarget.request("application/hal+json");
        Collection<CrazyHotelsResponse> crazyHotelsResponses = invocationBuilder.get().readEntity(new GenericType<Collection<CrazyHotelsResponse>>() {});
        assertTrue(!crazyHotelsResponses.isEmpty());
    }

    @Test(expected = Exception.class)
    public void whenCallHotelProvider_AndProviderNotExist_ThenShouldReturnListOfData() {
        WebTarget webTarget = client.target("http://localhost:8089/Dumyotel")
                .path(crazyHotelsRequest.getFrom())
                .path(crazyHotelsRequest.getTo())
                .path(crazyHotelsRequest.getCity())
                .path(String.valueOf(crazyHotelsRequest.getAdultsCount()));
        Invocation.Builder invocationBuilder =  webTarget.request("application/hal+json");
        Collection<CrazyHotelsResponse> crazyHotelsResponses = invocationBuilder.get().readEntity(new GenericType<Collection<CrazyHotelsResponse>>() {});
        assertTrue(!crazyHotelsResponses.isEmpty());
    }
}
