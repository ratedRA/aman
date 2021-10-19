package com.cpp.leetCode;

class SortedArraySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int l, int h, int target){
        if(l > h){
            return -1;
        }

        int mid = (l+h)/2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[l] <= nums[mid]){
            if(nums[l] <= target && nums[mid] >= target){
                return binarySearch(nums, l, mid-1, target);
            }

            return binarySearch(nums, mid+1, h, target);
        }


        if(nums[mid] <= target && nums[h] >= target){
            return binarySearch(nums, mid+1, h, target);
        }

        return binarySearch(nums, l, mid-1, target);

    }
}
