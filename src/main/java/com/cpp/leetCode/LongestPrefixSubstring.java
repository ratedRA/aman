package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestPrefixSubstring {
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
        FastReader fr = new FastReader();
        String spaceSeparatedStrs = fr.nextLine();
        String[] stringList = spaceSeparatedStrs.split("\\s+");

        String shortestString = longestPrefixSubstring(stringList);

        System.out.println(shortestString);
    }

    private static String longestPrefixSubstring(String[] stringList) {
        int shortestStringLength = Integer.MAX_VALUE;
        String shortestString = "";

        for(String str :  stringList){
            if(str.length() < shortestStringLength){
                shortestStringLength = str.length();
                shortestString = str;
            }
        }

        for(String str : stringList){
            while(!str.startsWith(shortestString)){
                shortestString = shortestString.substring(0, shortestStringLength-1);
                shortestStringLength -= 1;
            }
        }
        return shortestString;
    }
}
