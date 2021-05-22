package com.cpp;

import java.util.Scanner;

public class LastFibDigit {

    private void fib(int f[]){
        f[0] = 1;
        f[1] = 1;

        for(int i=2; i<60; i++){
            f[i] = (f[i-1] + f[i-2])%10;
        }
    }

    private int countPrimeFib(int a, int b){
        int[] f = new int[60];

        fib(f);
        int count = 0;

        for(int i=a; i<=b; i++){
            if(isPrime(f[i%60])){
                count+=1;
            }
        }
        return count;
    }

    private Boolean isPrime(int n){
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        LastFibDigit lfd = new LastFibDigit();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(lfd.countPrimeFib(a, b));
    }
}
