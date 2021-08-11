package com.cpp.randomQuestions;

import com.cpp.FastReader;

import java.util.Arrays;

public class SlidingWindowMinimumSwaps extends FastReader {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        System.out.println("enter the size of the array comprising of only 1 and 0");
        int n = fastReader.nextInt();
        System.out.println("enter the array");
        int[] onesAndZerosArray = fastReader.nextIntArray(n);

        int numberOfZerosToSwap = getNumberOfZerosToSwap(n, onesAndZerosArray);

        System.out.println("min swaps: "+numberOfZerosToSwap);
    }

    private static int getNumberOfZerosToSwap(int n, int[] onesAndZerosArray) {
        int allOnes = (int) Arrays.stream(onesAndZerosArray).filter(i -> i == 1).count();
        int x = allOnes;
        // get one cont in 1st subarray of size x

        int maxOnes = 0;
        for(int i=0; i<x; i++){
            if(onesAndZerosArray[i] == 1){
                maxOnes += 1;
            }
        }
        int newOnes = maxOnes;
        for(int i = 1; i<=n-x; i++){
            if(onesAndZerosArray[i-1] == 1){
                newOnes -= 1;
            }
            if(onesAndZerosArray[i+x-1] == 1){
                newOnes += 1;
            }
            maxOnes = Math.max(maxOnes, newOnes);
        }

        return allOnes - maxOnes;
    }
}
