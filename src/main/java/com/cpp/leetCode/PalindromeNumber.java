package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PalindromeNumber {
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
        FastReader reader = new FastReader();
        int num = reader.nextInt();

        isPalindrome(num);
    }

    private static boolean isPalindrome(int num) {
        if(num < 0){
            return false;
        }
        int reversedNum = 0;
        int tempNum = num;
        while(tempNum>0){
            reversedNum = reversedNum*10 + tempNum%10;
            tempNum = tempNum/10;
        }
        if(num == reversedNum){
            return true;
        }
        return false;
    }
}
