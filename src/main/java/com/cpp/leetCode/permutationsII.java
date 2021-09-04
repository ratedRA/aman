package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsII {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        int n = fastReader.nextInt();
        int[] inputArr = fastReader.nextIntArray(n);

        int[] hash = new int[10];
        Arrays.fill(hash, 0);

        for(Integer i : inputArr){
            hash[i] += 1;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 0; i<10; i++){
            if(hash[i] > 0){

            }
        }
    }

    private static List<List<Integer>> generate(List<Integer>, )
}
