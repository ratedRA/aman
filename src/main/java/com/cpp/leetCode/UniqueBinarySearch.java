package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.Arrays;

public class UniqueBinarySearch {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        int n = fastReader.nextInt();
        int trees = countTress(n);
        System.out.println(trees);
    }

    private static int countTress(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n ; i++){
            for(int j = 1; j<=i; j++){
                dp[i] = dp[i] + (dp[i-j] * dp[j-1]);
            }
        }
        return dp[n];
    }
}
