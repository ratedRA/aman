package com.cpp.leetCode;

import com.cpp.CommonFastReader;

/*
Find the highest index i such that s[i] < s[i+1].
If no such index exists, the permutation is the last permutation.
Find the highest index j > i such that s[j] > s[i]. Such a j must exist, since i+1 is such an index.
Swap s[i] with s[j].
Reverse the order of all of the elements after index i till the last element.
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        int n = fastReader.nextInt();
        int[] intArray = fastReader.nextIntArray(n);
        // int[] intArray = new int[]{1,3,2};
        nextPermutation(intArray);
        for(int i=0; i<intArray.length; i++){
            System.out.print(intArray[i]);
            System.out.print(" ");
        }
    }

    public static void nextPermutation(int[] nums) {
        Integer toBeSwapped = null;
        for(int i = nums.length-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                toBeSwapped = i-1;
                break;
            }
        }
        if(toBeSwapped == null){
            reverseOrder(nums, -1);
        } else{
            swap(nums, toBeSwapped, findHighestBiggestThanToBeSwapped(toBeSwapped, nums));
            reverseOrder(nums, toBeSwapped);
        }
    }

    private static int findHighestBiggestThanToBeSwapped(int index, int[] nums){
        int j = index+1;
        int indexTobeSwappedWith = j;
        while(j < nums.length){
            if(nums[j] > nums[index]){
                indexTobeSwappedWith = j;
            }
            j++;
        }
        return indexTobeSwappedWith;
    }

    private static void reverseOrder(int[] nums, int postIndex){
        int j = nums.length - 1;
        int i = postIndex+1;

        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
