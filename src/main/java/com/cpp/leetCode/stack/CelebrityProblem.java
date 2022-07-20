package com.cpp.leetCode.stack;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int n = 5;
        findCelebrity(n);
    }

    private static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            stack.push(i);
        }

        while (stack.size() > 1){
            Integer a = stack.pop();
            Integer b = stack.pop();
            if(knows(a,b)){
                stack.push(b);
            } else{
                stack.push(a);
            }
        }
        Integer ans = stack.pop();
        for(int i=0; i<n; i++){
            if(i==ans){
                continue;
            }
            if(knows(ans, i)){
                return -1;
            }
        }

        for(int i=0; i<n; i++){
            if(i==ans){
                continue;
            }
            if(!knows(i, ans)){
                return -1;
            }
        }
        return ans;
    }

    private static boolean knows(int a, int b){
        return false;
    }
}
