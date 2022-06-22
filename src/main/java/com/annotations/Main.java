package com.annotations;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

public class Main {
    private static Person person;
    private static final String FIRSTDIBS_EMAIL_DOMAIN = "1stdibs.com";
    private static final String FIRSTDIBS_EMAIL_PATTERN_REGEX =
            "^(.+)" + Pattern.quote(FIRSTDIBS_EMAIL_DOMAIN) + "$";
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, MalformedURLException, UnsupportedEncodingException {
        Integer[] a  = new Integer[5];
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
