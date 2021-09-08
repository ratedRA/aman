package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        int n = fastReader.nextInt();
        int[] nums = fastReader.nextIntArray(n);

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permutationsGenerator(curr, result, nums);
        System.out.println(result);
    }

    private static void permutationsGenerator(List<Integer> curr, List<List<Integer>> result, int[] nums){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != -100) {
                curr.add(nums[i]);
                int num = nums[i];
                nums[i] = -100;
                permutationsGenerator(curr, result, nums);
                curr.remove(curr.size()-1);
                nums[i] = num;
            }
        }
    }
}
