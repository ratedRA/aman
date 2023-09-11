package com;

import java.util.Arrays;

public class TestingMutability {
    public static void main(String[] args) {
        //int[] nums = {1,2,3,4};
        String s = "aman";
        s = "shivam";
        System.out.println(s);
        change(s);
        System.out.println(s);
    }

    static void change(String s){
        s = "shivam";
    }
}
