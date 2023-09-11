package com;

public class SplitArray {
    public static void main(String[] args) {
        int[] splitArr = {1, 2, 3, 4, 5, 6, 7};
        int splitFactor = 3;
        int outertItr = 0;
        int innerItr = 0;
        while(outertItr < splitArr.length){
            while(innerItr < splitFactor && outertItr<splitArr.length){
                System.out.print(splitArr[outertItr]);
                innerItr+=1;
                outertItr+=1;
            }
            System.out.println();
            innerItr = 0;
        }
    }
}
