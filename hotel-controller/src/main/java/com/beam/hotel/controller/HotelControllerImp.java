package com.beam.hotel.controller;

import com.beam.hotel.exception.HotelException;
import com.beam.hotel.hateoas.Hypermedia;
import com.beam.hotel.request.GetHotelRequest;
import com.beam.hotel.response.GetHotelResponse;
import com.beam.hotel.service.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value = "/hotels")
@Api(description = "Crazy hotel Application API (Get Hotel).")
public class HotelControllerImp implements HotelController {

    @Autowired
    private HotelService service;
    private Hypermedia hypermedia = new Hypermedia();

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{fromDate}/{toDate}/{city}/{numberOfAdults}", produces = {"application/hal+json"})
    @CrossOrigin()
    @ApiOperation(value = "Method to list hotels.", notes = "This method used when you want to list hotels.")
    public Collection<Resource<GetHotelResponse>> getHotels(@PathVariable String fromDate, @PathVariable String toDate, @PathVariable String city, @PathVariable Integer numberOfAdults) {
        try {
            Collection<Resource<GetHotelResponse>> resources = new ArrayList<>();
            service.getHotels(new GetHotelRequest(fromDate, toDate, city, numberOfAdults)).forEach(e -> {
                resources.add(hypermedia.getAccountResources(e));
            });
            return resources;
        }catch (Exception ex) {
            throw new HotelException(ex.getMessage());
        }
    }
}
