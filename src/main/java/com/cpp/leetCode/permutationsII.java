package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class permutationsII {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        int n = fastReader.nextInt();
        int[] nums = {1, 1, 2};

        // for positive only
        int[] hash = new int[10];
        Arrays.fill(hash, 0);

        for(Integer i : nums){
            hash[i] += 1;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generate(curr, resultList, hash, nums.length);
        System.out.println(resultList);

        // for all integers
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Integer i : nums){
            hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
        }
        List<List<Integer>> resultList2 = new ArrayList<>();
        List<Integer> curr2 = new ArrayList<>();
        generateAllIntegers(curr2, resultList2, hashMap, nums);
        System.out.println(resultList2);
    }

    private static void generate(List<Integer> current, List<List<Integer>> result, int[] hash, int n){
        if(current.size() == n){
            result.add(new ArrayList<>(current));
            return ;
        }

        for(int i = 0; i<10; i++){
            if(hash[i] > 0){
                hash[i] -= 1;
                current.add(i);
                generate(current, result, hash, n);
                current.remove(current.size()-1);
                hash[i] += 1;
            }
        }
    }

    private static void generateAllIntegers(List<Integer> curr, List<List<Integer>> result, Map<Integer, Integer> map, int[] nums){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return ;
        }

        for(int num : map.keySet()){
            if(map.get(num) > 0){
                map.put(num, map.get(num)-1);
                curr.add(num);
                generateAllIntegers(curr, result, map, nums);
                map.put(num, map.get(num)+1);
                curr.remove(curr.size() -1);
            }
        }
    }

}
