package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringAtoI {
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
        StringAtoI stringAtoI = new StringAtoI();

        String s = reader.nextLine();
        stringAtoI.convertString(s);

    }

    private int convertString(String s) {
        int index = 0;
        boolean isNegative = false;
        long res = 0;
        while(index < s.length() && s.charAt(index) == ' '){
            index++;
        }
        if(index >= s.length()){
            return 0;
        }
        if(s.charAt(index) == '-' || s.charAt(index) == '+'){
            isNegative = s.charAt(index) == '-'?true:false;
            index++;
        }
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            res = res*10 + s.charAt(index) - '0';
            if(res > Integer.MAX_VALUE && isNegative){
                return Integer.MIN_VALUE;
            }
            if(res > Integer.MAX_VALUE && !isNegative){
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return isNegative? (int) (-1 * res) : (int) res;
    }
}
