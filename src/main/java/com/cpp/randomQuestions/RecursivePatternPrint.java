package com.cpp.randomQuestions;

public class RecursivePatternPrint {
    public static void main(String[] args) {
        printPattern(8);
    }

    private static void printPattern(int n){
        if(n == 0){
            return;
        }
        for(int i =1; i<=n; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        printPattern(n-1);
        //System.out.println(n);


    }
}
