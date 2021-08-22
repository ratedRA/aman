package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.Scanner;

public class FirstMissingPositive {
    public static void main(String[] args) {
        CommonFastReader commonFastReader = new CommonFastReader();
        int n = commonFastReader.nextInt();
        int res = firstMissingPositive(new CommonFastReader().nextIntArray(n));
        System.out.println(res);
    }
        private static int firstMissingPositive(int[] nums) {
            int size = nums.length;
            int negativeCount = 0;
            for(int i=0; i<size; i++){
                if(nums[i] <= 0){
                    negativeCount += 1;
                }
            }
            int[] positiveArr = new int[size-negativeCount];
            int j = 0;
            for(int i=0; i<size; i++){
                if(nums[i] > 0){
                    positiveArr[j] = nums[i];
                    j+=1;
                }
            }

            for(int k=0; k<positiveArr.length; k++){
                int x = Math.abs(positiveArr[k]);
                if(x-1 < positiveArr.length && x-1 >= 0 && positiveArr[x-1] > 0){
                    positiveArr[x-1]  = -1*positiveArr[x-1];
                }
            }

            //System.out.println(nums);
            for(int i = 0; i<positiveArr.length; i++){
                if(positiveArr[i] > 0){
                    return i+1;
                }
            }
            return positiveArr.length+1;
        }
    }

