package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseAnInteger {
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
        FastReader fs = new FastReader();

        // read the intger
        int number = fs.nextInt();
        int integer = reverseAnInteger(number);
        System.out.println(integer);
    }

    private static int reverseAnInteger(int number) {
        int reversedNumber = 0;
        boolean flipSign = false;
        if(number < 0){
            flipSign = true;
            number = -1*number;
        }
        int prev_num = 0;
        while(number != 0){
             reversedNumber = reversedNumber*10 + number%10;

             // when there's an operation that increases a number, reversing the operation should give you the previous number
             if((reversedNumber-number%10)/10 != prev_num){
                 // overflowed
                 return 0;
             }
             prev_num = reversedNumber;
             number = number/10;
        }
        reversedNumber = flipSign?-1*reversedNumber:reversedNumber;
        return reversedNumber;
    }
}
