package com.beam.hotel.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IATACodeValidation {

    private static final String REGEX = "([A-Z]{3,3})|([A-Z] [A-Z])";
    private static Pattern pattern;
    private Matcher matcher;

    public IATACodeValidation() {
        pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
    }

    public Boolean validate(String email) {
        matcher = pattern.matcher(email);
        Boolean result = matcher.matches();
        return result;
    }
}
