package com.cpp.leetCode;

import com.cpp.CommonFastReader;

public class maximumSubarray {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        int n = fastReader.nextInt();
        int[] nums = fastReader.nextIntArray(n);

        int maxSubSum = getMaxSubSum(nums);
        System.out.println(maxSubSum);
    }

    private static int getMaxSubSum(int[] nums) {
        int maxSubSum = Integer.MIN_VALUE;
        int curSum = 0;

        for(int i=0; i<nums.length; i++){
            curSum = Math.max(curSum+nums[i], nums[i]);
            maxSubSum = Math.max(curSum, maxSubSum);
        }
        return maxSubSum;
    }
}
