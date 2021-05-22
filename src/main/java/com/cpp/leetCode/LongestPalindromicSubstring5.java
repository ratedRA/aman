package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestPalindromicSubstring5 {

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

        // read String
        //String s = reader.nextLine();
        //String longestPalindromicSubstring = bruteForcePalindromicSubstring(s);
        String optimizedLps = optimizedLongestPalindromicString("bb");
        System.out.println(optimizedLps);
    }

    //O(n^3)
    private static String bruteForcePalindromicSubstring(String s) {
        for(int len=s.length(); len>0; len--){
            for(int i=0; i+len<=s.length(); i++){
                String substring = s.substring(i, i + len);
                if(isPalindrome(substring)){
                    return substring;
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(String s){
        int lowerIndex = 0;
        int higherIndex = s.length()-1;

        while(lowerIndex<=higherIndex && s.charAt(lowerIndex)==s.charAt(higherIndex)){
            lowerIndex++;
            higherIndex--;
        }
        return lowerIndex>=higherIndex;
    }

    private static String optimizedLongestPalindromicString(String s){
        int maxLength = 0;
        String longestPalindromicSubstring = "";
        for(int i=0; i<s.length(); i++){
            String oddLengthPalindrome = expandSubstringPalindromeCheck(s, i, i);
            String evenLengthPlaindrome = expandSubstringPalindromeCheck(s, i, i+1);
            if(longestPalindromicSubstring.length() < oddLengthPalindrome.length()){
                longestPalindromicSubstring = oddLengthPalindrome;
            }  if(longestPalindromicSubstring.length() < evenLengthPlaindrome.length()){
                longestPalindromicSubstring = evenLengthPlaindrome;
            }
        }
        return longestPalindromicSubstring;
    }

    private static String expandSubstringPalindromeCheck(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

}
