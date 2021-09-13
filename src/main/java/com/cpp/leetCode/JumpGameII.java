package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        CommonFastReader reader = new CommonFastReader();
        int n = reader.nextInt();
        int[] nums = reader.nextIntArray(n);
        int[] dp = minJump(n, nums);
        System.out.println(dp[n-1]);
    }

    private static int[] minJump(int n, int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(j+nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp;
    }
}
