package com.cpp.randomQuestions;

public class RecursivePatternPrint {
    public static void main(String[] args) {
        // printPattern(8);
        printComplexPattern(8);
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

    private static void printComplexPattern(int n){
        if(n == 1){
            System.out.println("1");
            return;
        }
        for(int i = 1; i<=n; i++){
            System.out.print(i+" ");
        }
        System.out.println();

        printComplexPattern(n-1);

        for(int i = 1; i<=n; i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
