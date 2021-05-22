package com.cpp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {

    public static void main(String[] args) {
        Map<String, Integer> mapToSort = new HashMap<>();
        mapToSort.put("Math", 98);
        mapToSort.put("Data Structure", 85);
        mapToSort.put("Database", 91);
        mapToSort.put("Java", 95);
        mapToSort.put("Operating System", 79);
        mapToSort.put("Networking", 80);

        // sorting by value using traditional comparator
        Map<String, Integer> sortedMap1 = sortByValueComparator(mapToSort);
        sortedMap1.entrySet().stream().forEach(ele -> System.out.println(ele.getKey()+ " " +ele.getValue()));

        // sorting by value using java8 streams in reverse order.
        Map<String, Integer> sortedMap2 = mapToSort.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (first, conflict)-> first, LinkedHashMap::new));
        System.out.println(sortedMap2);

    }

    private static Map<String, Integer> sortByValueComparator(Map<String, Integer> mapToSort) {
        List<Map.Entry<String, Integer>> mapEleList = new ArrayList<>(mapToSort.entrySet());
        Collections.sort(mapEleList, (v1, v2)->{
            return v1.getValue().compareTo(v2.getValue());
        });

        Map<String, Integer> map = mapEleList.stream().collect(Collectors.toMap(aa->aa.getKey(), a->a.getValue(), (first, conflict)->first, LinkedHashMap::new));
        return map;
    }
}
