package com.cpp.stringManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.*;

import java.util.*;
import java.util.Map.Entry;

public class ReverseString {
    private static final String YES = "YES";
    private static final String NO = "NO";

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
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
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0){
            String ticketNumber = sc.nextLine();
            //String reversedOne = Reverse.getStringReverse(ticketNumber);
            //System.out.println(ticketNumber+" "+ reversedOne);
            if(ticketNumber.equals(getStringReverse(ticketNumber))){
                System.out.println(YES);
            }
            else{
                System.out.println(NO);
            }
            t-=1;
        }
    }

    private static String getStringReverse(String s){
        char[] ticketNumbers = s.toCharArray();
        List<Character> listNumber = new ArrayList<>();

        for(char c:ticketNumbers){
            listNumber.add(c);
        }
        Collections.reverse(listNumber);
        ListIterator li = listNumber.listIterator();
        String res = "";
        while (li.hasNext())
            res+=li.next();
        return res;
    }
}
