// if String a could be converted to b by the adding some value to any length of prefix a.

package com.cpp.stringManipulation;

import java.util.Scanner;

public class AliceString {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(getVal(a,b));
    }
    private static String getVal(String a, String b){
        int size = a.length();
        int prevDiff = 0;
        for(int i = 0; i<size; i++){
            int diffBetweenChars = (int)(a.charAt(size-1-i)) - (int)(b.charAt(size-1-i));
            //System.out.println(diffBetweenChars);
            if(diffBetweenChars <= 0 && Math.abs(diffBetweenChars) >= prevDiff){
                prevDiff = diffBetweenChars;
                //System.out.println("yes");
            }
            else{
                return NO;
            }
        }
        return YES;
    }
}
