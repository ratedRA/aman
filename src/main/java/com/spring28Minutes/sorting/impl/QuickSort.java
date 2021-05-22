package com.spring28Minutes.sorting.impl;

import com.spring28Minutes.sorting.SortAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Qualifier(("quickSort"))
public class QuickSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        System.out.println("sorting using quick sort");
        Arrays.sort(array);
        return array;
    }
}
