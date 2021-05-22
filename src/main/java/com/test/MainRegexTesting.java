package com.test;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegexTesting {
    public static void main(String[] args) {
        String stringPattern = "(\\d{1,2}([-./])\\d{1,2}([-./])\\d{4}|\\d{1,2}([-./])\\d{1,2}([-./])\\d{4} ([01]?[0-9]|2[0-3]):[0-5][0-9].*)";
        String userAgentRegex = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
        String stringPatternEmail = ".*";
        Pattern date = Pattern.compile(stringPattern);
        Pattern email = Pattern.compile(stringPatternEmail);
        boolean matches = date.matcher("1stDibs/101.19.101000 CFNetwork/1121.2.2 Darwin/19.3.0").matches();
        boolean matches1 = email.matcher("aman.prawefogweofh8943gruwgciusdvcvsad@gmail.com").matches();
        Optional<DataType> typeOfField = DataType.getTypeOfField("24/12/1996 12:34");
        //System.out.println(typeOfField.get().name());
        Pattern userAgentPattern = Pattern.compile(userAgentRegex);
        Matcher userAgentMatcher = userAgentPattern.matcher("com.1stdibs.1stdibs.buyer v1.19.5 b101.19.105002 iPhone iPhone12,1 14.4.2 866F9966-7390-4C0E-ADF8-F5C8E3D601E0 Session:32");
        UUID uuid = UUID.fromString("F-4-F-6-C");
        System.out.println(uuid);

        int count = 0;
        if (userAgentMatcher.find())
        {
            System.out.println(userAgentMatcher.group());
        }
        System.out.println(count);
    }
}
