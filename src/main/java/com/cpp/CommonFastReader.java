package com.cpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonFastReader {
    BufferedReader br;
    StringTokenizer st;

    public CommonFastReader(){
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

    public int nextInt(){
        return Integer.parseInt(next());
    }

    public Long nextLong(){
        return Long.parseLong(next());
    }

    public Double nextDouble(){
        return Double.parseDouble(next());
    }

    public String nextLine()
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

    public int[] nextIntArray(int n){
        int[] nums = new int[n];
        int i = 0;
        while(n-->0){
            nums[i] = nextInt();
            i++;
        }
        return nums;
    }

    public String[] nextStringArray(int n){
        String[] strs = new String[n];
        int i = 0;
        while(n-->0){
            strs[i] = nextLine();
            i++;
        }
        return strs;
    }
}
