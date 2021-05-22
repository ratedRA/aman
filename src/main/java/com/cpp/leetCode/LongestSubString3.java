package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/*
traverse through the String and keep on increasing the start
index of the substring if duplicate found to the index which just follows it.
 */
public class LongestSubString3 {

    static  class FastReader{
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
        FastReader in = new FastReader();
        String inputString = in.nextLine();
        int maxLengthSubstring = getMaxLengthSubstring(inputString);
        System.out.println(maxLengthSubstring);
    }

    private static int getMaxLengthSubstring(String inputString) {
        Map<Character, Integer> characterToIndexMap = new HashMap<>();
        int subStringStartIndex = 0;
        int maxLength = 0;
        for(int i = 0; i<inputString.length(); i++){
            Character c = inputString.charAt(i);
            if(characterToIndexMap.containsKey(c)){
                subStringStartIndex = Math.max(subStringStartIndex, characterToIndexMap.get(c)+1);
            }
            characterToIndexMap.put(c, i);
            maxLength = Math.max(maxLength, i-subStringStartIndex+1);
        }

        return maxLength;
    }
}
