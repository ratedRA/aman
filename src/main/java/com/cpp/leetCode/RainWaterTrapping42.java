package com.cpp.leetCode;

import com.cpp.CommonFastReader;

public class RainWaterTrapping42 {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader() ;
        int n = fastReader.nextInt();
        int[] heights = fastReader.nextIntArray(n);

    }

    private static int trap(int[] heights){
        int maxLeft = heights[0];
        int maxRight = heights[heights.length-1];
        if(heights.length <= 1){
            return 0;
        }

        int left = 0;
        int right = heights.length-1;
        int waterTrapped = 0;
        while(left<right){
            if(maxLeft < maxRight) {
                if (heights[left] >= maxLeft) {
                    maxLeft = heights[left];
                } else {
                    waterTrapped += maxLeft - heights[left];
                }
                left += 1;
            } else{
                if (heights[right] >= maxRight) {
                    maxRight = heights[right];
                } else {
                    waterTrapped += maxRight - heights[right];
                }
                right -= 1;
            }

        }
        return waterTrapped;
    }
}
