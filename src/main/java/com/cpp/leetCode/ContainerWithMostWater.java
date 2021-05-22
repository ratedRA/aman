package com.cpp.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContainerWithMostWater {
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
        int n = fr.nextInt();
        int[] heights = fr.nextIntArray(n);

        int maxArea = getMaxArea(heights);

        System.out.println(maxArea);
    }

    private static int getMaxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while(left < right){
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            maxArea = Math.max(maxArea, (right - left) * (Math.min(leftHeight,rightHeight)));
            if(leftHeight > rightHeight){
                right -= 1;
            } else{
                left += 1;
            }
        }
        return maxArea;
    }
}
