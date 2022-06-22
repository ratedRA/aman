package com.test;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegexTesting {
    public static void main(String[] args) {
        String stringPattern = "(\\d{1,2}([-./])\\d{1,2}([-./])\\d{4}|\\d{1,2}([-./])\\d{1,2}([-./])\\d{4} ([01]?[0-9]|2[0-3]):[0-5][0-9].*)";
        String userAgentRegex = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
        String rangeRegexPattern = "(.*)\\[(.*) TO (.*)\\](.*)";
        String rangeRegexPattern2 = "\\[(.*) TO (.*)](.*)";
        String stringPatternEmail = ".*";
        String alpaNumUnHy = "[A-Za-z0-9_-]+";
        Pattern alpaNumUnHyPattern = Pattern.compile(alpaNumUnHy);
        Pattern date = Pattern.compile(stringPattern);
        Pattern email = Pattern.compile(stringPatternEmail);
        Pattern SELECT_ID_SQL_PATTERN =
                Pattern.compile("(select\\s+)(.*)(\\s+from)(.*)(limit\\s+@pageStart@|replace@,\\s+@pageSize@|replace@)", Pattern.CASE_INSENSITIVE);
        boolean matches = date.matcher("1stDibs/101.19.101000 CFNetwork/1121.2.2 Darwin/19.3.0").matches();
        boolean matches1 = email.matcher("aman.prawefogweofh8943gruwgciusdvcvsad@gmail.com").matches();
        boolean sqlmatcher = SELECT_ID_SQL_PATTERN.matcher("select id from identity where 1=1 and x=2 limit @pageStart@|replace@,    @pageSize@|replace@").matches();
        Optional<DataType> typeOfField = DataType.getTypeOfField("24/12/1996 12:34");
        //System.out.println(typeOfField.get().name());
        Pattern userAgentPattern = Pattern.compile(userAgentRegex);
        Matcher userAgentMatcher = userAgentPattern.matcher("com.1stdibs.1stdibs.buyer v1.19.5 b101.19.105002 iPhone iPhone12,1 14.4.2 866F9966-7390-4C0E-ADF8-F5C8E3D601E0 Session:32");
        UUID uuid = UUID.fromString("F-4-F-6-C");
        //System.out.println(uuid);

//        int count = 0;
//        if (userAgentMatcher.find())
//        {
//            System.out.println(userAgentMatcher.group());
//        }
//        System.out.println(count);
//        Matcher rangeMatcher = SELECT_ID_SQL_PATTERN.rangeMatcher("select id from identity limit @pageStart@|replace@,    @pageSize@|replace@");
//        String selectBody = null;
//        if (rangeMatcher.matches()) {
//            System.out.println(rangeMatcher.group(2));
//        }
//        System.out.println(sqlmatcher);

//        Pattern rangeReg = Pattern.compile(rangeRegexPattern);
//        Pattern rangeReg2 = Pattern.compile(rangeRegexPattern2);
//        Matcher rangeMatcher = rangeReg.matcher("categoryL1=furniture&categoryL2=seating&price=[1 TO 6000]&style=industrial,mid-century-modern");
//        Matcher rangeMatcher2 = rangeReg2.matcher("[1 TO 6000]");
//        System.out.println(rangeMatcher.matches());
//        System.out.println(rangeMatcher.group(2) + " " + rangeMatcher.group(3));
//        System.out.println(rangeMatcher2.matches());
//        System.out.println(rangeMatcher2.group(1) + " " + rangeMatcher2.group(2));

        boolean matches2 = alpaNumUnHyPattern.matcher("dining-entertaining").matches();
        System.out.println(matches2);

    }
}
