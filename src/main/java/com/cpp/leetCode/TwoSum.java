package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TwoSum {

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
        FastReader in = new FastReader();
        Ques solver;
        solver = new Ques();

        solver.solve(1, in);
    }

    static class Ques {
        public void solve(int testNumber, FastReader in) {
            int n = in.nextInt();
            //int a[][]=new int[n][3]
            int[] nums = in.nextIntArray(n);
            int target = in.nextInt();
            int[] res = twoSum(nums, target);
            for (Integer j :
                    res) {
                System.out.println(j);
            }
        }

        private int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> elements = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (elements.containsKey(nums[i])) {
                    return new int[]{i, elements.get(nums[i])};
                }
                elements.put(target - nums[i], i);
            }
            return null;
        }
    }
}
