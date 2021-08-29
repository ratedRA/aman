package com.cpp.leetCode;

import java.util.HashMap;
import java.util.Map;

public class CountStairs {
    Map<Integer, Integer> dp = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 2 || n == 1 || n == 0){
            return n;
        }

        if(dp.containsKey(n)){
            return dp.get(n);
        }

        int count = climbStairs(n-1) + climbStairs(n-2);
        dp.put(n, count);

        return dp.get(n);
    }
}
