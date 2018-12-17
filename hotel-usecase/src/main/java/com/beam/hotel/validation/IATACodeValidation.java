package com.beam.hotel.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IATACodeValidation {

    private static final String EMAIL_REGEX = "/^[A-Z]{3}$/";
    private static Pattern pattern;
    private static Matcher matcher;

    public IATACodeValidation() {
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    public static Boolean validate(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
