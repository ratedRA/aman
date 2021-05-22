package com.spring28Minutes.sorting.impl;

import com.spring28Minutes.sorting.SortAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Qualifier("bubbleSort")
public class BubbleSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        System.out.println("sorting using bubble sort");
        Arrays.sort(array);
        return array;
    }
}
