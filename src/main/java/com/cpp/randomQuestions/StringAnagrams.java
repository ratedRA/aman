package com.cpp.randomQuestions;

import com.cpp.CommonFastReader;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringAnagrams extends CommonFastReader {
    public static void main(String[] args) {
        CommonFastReader commonFastReader = new CommonFastReader();
        String inputString = commonFastReader.nextLine();

        List<String> strings = generateAndReturnAnagrams(inputString, "", new ArrayList<>());
        System.out.println(strings);

        Set<String> uniqueAnagrams = generateUniqueAndReturnAnagrams(inputString, "", new HashSet<>());
        System.out.println(uniqueAnagrams);
    }

    private static List<String> generateAndReturnAnagrams(String str, String anagram, List<String> resList){
        if(StringUtils.isEmpty(str)){
            resList.add(anagram);
            return resList;
        }

        for(int i=0; i<str.length(); i++){
            Character cur = str.charAt(i);

            String restStr = str.substring(0, i) + str.substring(i+1);
            generateAndReturnAnagrams(restStr, anagram+cur, resList);
            //System.out.println(resList);
        }
        return resList;
    }

    private static Set<String> generateUniqueAndReturnAnagrams(String str, String anagram, Set<String> resList){
        if(StringUtils.isEmpty(str)){
            resList.add(anagram);
            return resList;
        }

        for(int i=0; i<str.length(); i++){
            Character cur = str.charAt(i);

            String restStr = str.substring(0, i) + str.substring(i+1);
            generateUniqueAndReturnAnagrams(restStr, anagram+cur, resList);
            //System.out.println(resList);
        }
        return resList;
    }
}
