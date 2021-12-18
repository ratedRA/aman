package com.cpp.leetCode;

public class JumpGame55 {

    private boolean canJump(int[] nums){
        int curMax = 0;
        for(int i=0; i<nums.length && curMax>=i; i++){
            curMax = Math.max(curMax, nums[i]+i);
        }
        return curMax >= nums.length-1;
    }
}
