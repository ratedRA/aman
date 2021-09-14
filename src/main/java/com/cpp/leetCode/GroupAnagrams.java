package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        CommonFastReader reader = new CommonFastReader();
        int n = reader.nextInt();
        String[] strs = reader.nextStringArray(n);
        Map<String, List<String>> hashedMap = groupAnagrams(strs);
        List<List<String>> result = new ArrayList<>();
        for(List<String> strs1 : hashedMap.values()){
            result.add(strs1);
        }
        System.out.println(result);
    }

    private static Map<String, List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashedMap = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String hashedStringValue = generateHashedString(strs[i]);
            if(!hashedMap.containsKey(hashedStringValue)) {
                List<String> val = new ArrayList<>();
                val.add(strs[i]);
                hashedMap.put(hashedStringValue, val);
            } else {
                hashedMap.get(hashedStringValue).add(strs[i]);
            }
        }
        return hashedMap;
    }

    private static String generateHashedString(String inputString){
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        StringBuilder builder = new StringBuilder("#");
        for(int i=0; i<inputString.length(); i++){
            hash[(int) inputString.charAt(i) - (int) 'a'] += 1;
        }
        for(int i=0; i<26; i++){
            builder.append(hash[i]);
            builder.append("#");
        }
        return builder.toString();
    }
}
