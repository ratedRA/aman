package com.cpp.randomQuestions;

import org.apache.commons.lang.StringUtils;

public class ReverseString {
    public static void main(String[] args) {
        String reverseString = stringReversed("This string will be reversed");
        System.out.println(reverseString);
    }

    private static String stringReversed(String s){
        if(StringUtils.isEmpty(s)){
            return s;
        } else {
            return s.charAt(s.length()-1) + stringReversed(s.substring(0, s.length()-1));
        }
    }
}
