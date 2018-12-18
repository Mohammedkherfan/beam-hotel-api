package com.beam.hotel.validation;

import com.beam.hotel.exception.*;
import com.beam.hotel.request.GetHotelRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public class HotelValidation {

    public void getHotelsRequestValidation(GetHotelRequest request) {
        this.fromDateValidation.validate(request.getFromDate());
        this.toDateValidation.validate(request.getToDate());
        this.fromDateFormatValidation.validate(request.getFromDate());
        this.toDateFormatValidation.validate(request.getToDate());
        this.fromDateWithCurrentValidation.validate(request.getFromDate());
        this.toDateWithCurrentValidation.validate(request.getToDate());
        this.cityValidation.validate(request.getCity());
        this.cityIATAValidation.validate(request.getCity());
        this.numberOfAdultsValidation.validate(request.getNumberOfAdults());
        this.numberOfAdultsGreaterThenZeroValidation.validate(request.getNumberOfAdults());
        checkFromAndToDate(request.getFromDate(), request.getToDate());
    }

    @FunctionalInterface
    public interface Validation<T> {
        void validate(T value);
    }

    private Validation<String> fromDateValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidHotelFromDateException("Invalid hotel from date - hotel from date is null or empty");
        }
    });

    private Validation<String> toDateValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidHotelToDateException("Invalid hotel to date - hotel to date is null or empty");
        }
    });

    private Validation<String> fromDateFormatValidation = (value -> {
        if (!checkDateFormatIsValid(value)) {
            throw new InvalidHotelFromDateException("Invalid hotel from date - hotel from date not applicable with ISO date format");
        }
    });

    private Validation<String> toDateFormatValidation = (value -> {
        if (!checkDateFormatIsValid(value)) {
            throw new InvalidHotelToDateException("Invalid hotel from date - - hotel to date not applicable with ISO date format");
        }
    });

    private Validation<String> fromDateWithCurrentValidation = (value -> {
        if (LocalDate.parse(value).isBefore(LocalDate.now())) {
            throw new InvalidHotelFromDateException("Invalid hotel from date - hotel from can not before current date");
        }
    });

    private Validation<String> toDateWithCurrentValidation = (value -> {
        if (LocalDate.parse(value).isBefore(LocalDate.now())) {
            throw new InvalidHotelToDateException("Invalid hotel to date - hotel to can not before current date");
        }
    });

    private Validation<String> cityValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidHotelCityException("Invalid hotel city - city is null or empty");
        }
    });

    private Validation<String> cityIATAValidation = (value -> {
        IATACodeValidation validation = new IATACodeValidation();
        if (!validation.validate(value)) {
            throw new InvalidHotelCityException("Invalid hotel city - city not match with IATA RegEx");
        }
    });

    private Validation<Integer> numberOfAdultsValidation = (value -> {
        if (isNull(value)) {
            throw new InvalidHotelNumberOfAdultsException("Invalid hotel number of adults - number of adults is null");
        }
    });

    private Validation<Integer> numberOfAdultsGreaterThenZeroValidation = (value -> {
        if (value < 1) {
            throw new InvalidHotelNumberOfAdultsException("Invalid hotel number of adults - minimum number of adults shall be one");
        }
    });


    private Boolean checkDateFormatIsValid(String date) {
        try {
            LocalDate.parse(date).format(DateTimeFormatter.ISO_LOCAL_DATE);
            return Boolean.TRUE;
        }catch (Exception ex) {
            return Boolean.FALSE;
        }
    }

    private void checkFromAndToDate(String fromDate, String toDate) {
        if (LocalDate.parse(fromDate).isAfter(LocalDate.parse(toDate)) || LocalDate.parse(toDate).isBefore(LocalDate.parse(fromDate)))
            throw new HotelException("Invalid from or to date, maybe from date is after to date or else");
    }
}
