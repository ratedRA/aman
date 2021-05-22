package com.cpp.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String arrangeWords(String text) {
        List<String> stringList = Arrays.asList(text.trim().split("\\s+"));
        Map<String, List<Integer>> countMap = new LinkedHashMap<>();
        for (String str : stringList) {
            if (countMap.get(str) != null) {
                countMap.get(str).add(str.length());
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(str.length());
                countMap.put(str, integers);
            }
        }
        System.out.println(countMap);
        countMap = countMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().get(0)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(countMap);

        String result = "";
        int index = 0;
        Iterator<Map.Entry<String, List<Integer>>> itr = countMap.entrySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().getKey();
            if (index == 0) {
                key = key.substring(0, 1).toUpperCase() + key.substring(1);
                result += key;
            } else {
                result += key;
            }
            if (itr.hasNext()) {
                result += " ";
            }
            index += 1;
        }

        return result;
    }
}

public class RearrangeWords {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.arrangeWords("To be or not to be"));
    }
}
