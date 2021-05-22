package com.spring28Minutes.searching.impl;

import com.spring28Minutes.sorting.SortAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch {
    @Autowired
    @Qualifier("quickSort")
    private SortAlgorithm sortAlgorithm;

    public int search(int[] array, int number){
        int[] a = sortAlgorithm.sort(array);
        System.out.println("the sort algorithm used is"+sortAlgorithm.getClass());
        return 3;
    }
}
