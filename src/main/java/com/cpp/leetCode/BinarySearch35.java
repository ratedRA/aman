package com.cpp.leetCode;

import com.cpp.CommonFastReader;

public class BinarySearch35 {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();

        int n = fastReader.nextInt();
        int[] nums = fastReader.nextIntArray(n);

        int target = fastReader.nextInt();

        int index = searchInsert(nums, target);
        System.out.println(index);
    }

    private static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int mid = 0;


        while (l<=r){
            //System.out.println(l + " " + r);
            mid = l+(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }

            else if(nums[mid] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }

        }

        return r+1;
    }
}
