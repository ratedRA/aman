package com.test;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum DataType {
    DATE("(\\d{1,2}([-./])\\d{1,2}([-./])\\d{4}|\\d{1,2}([-./])\\d{1,2}([-./])\\d{4} ([01]?[0-9]|2[0-3]):[0-5][0-9].*|\\d{4}([-./])\\d{1,2}([-./])\\d{1,2}|\\d{4}([-./])\\d{1,2}([-./])\\d{1,2} ([01]?[0-9]|2[0-3]):[0-5][0-9].*)"),
    TEXT(".*");


    private String regex;
    DataType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public static Optional<DataType> getTypeOfField(String fieldValues) {
        return Arrays.stream(values())
                .filter(dt -> Pattern.compile(dt.getRegex()).matcher(fieldValues).matches()).findFirst();
    }
}
