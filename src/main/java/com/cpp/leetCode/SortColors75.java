package com.cpp.leetCode;

/**
 *  dutch national flag algo -
 *  a[mid] = 0 -> swap(a[mid], a[low]), mid++, low++
 *  a[mid] = 1 -> mid++,
 *  a[mid] = 2 -> swap(a[mid], a[high]), high--;
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        int low = 0 , mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            switch (nums[mid]){
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, high, mid);
                    high--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
