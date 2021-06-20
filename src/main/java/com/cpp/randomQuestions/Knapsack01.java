package com.cpp.randomQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack01 {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextIntArray(int n){
            int[] nums = new int[n];
            int i = 0;
            while(n-->0){
                nums[i] = nextInt();
                i++;
            }
            return nums;
        }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        System.out.println("enter the size of knapsack");
        int n = sc.nextInt();

        System.out.println("enter the profits of each item in knapsack");
        int[] profits = sc.nextIntArray(n);

        System.out.println("enter the weights of each item in knapsack");
        int[] weights = sc.nextIntArray(n);

        System.out.println("enter the capacity of knapsack");
        int capacity = sc.nextInt();

        int maxProfit = maxProfitKnapsackRecursive(profits, weights, capacity, 0);
        System.out.println(maxProfit);
    }

    private static int maxProfitKnapsackRecursive(int[] profits, int[] weights, int capacity, int index){
        if(capacity <= 0 || index  >= profits.length){
            return 0;
        }

        int profit1=0;
        if(weights[index] <= capacity){
            profit1 = profits[index] + maxProfitKnapsackRecursive(profits, weights, capacity - weights[index], index+1);
        }

        int profit2 = maxProfitKnapsackRecursive(profits, weights, capacity, index+1);

        return Math.max(profit1, profit2);
    }

    private static int maxProfitKnapsackBottomUpDynamic(int[] profits, int[] weights, int capacity){
        int n = profits.length;
        if(capacity <= 0 || profits.length <= 0 || profits.length != weights.length){
            return 0;
        }

        int[][] dp = new int[n][capacity+1];

        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }

        for(int c=0; c<capacity; c++){
            if(weights[0] <= c){
                dp[0][c] = profits[0];
            }
        }

        for(int i=1; i<n; i++){
            for(int c=1; c<=capacity; c++){
                int profit1 = 0;
                int profit2 = 0;

                if(weights[i] <= c){
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                }
                profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n-1][capacity];
    }
}
