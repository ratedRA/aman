package com.cpp.leetCode;

import com.cpp.CommonFastReader;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis extends CommonFastReader {
    public static void main(String[] args) {
        CommonFastReader commonFastReader = new CommonFastReader();
        String stringWithParenthesis = commonFastReader.nextLine();

        boolean isValid = isValid(stringWithParenthesis);

        System.out.println(isValid);

    }

    private static boolean isValid(String stringWithParenthesis) {
        boolean isValid = true;

        Map<Character, Character> parenthesisMatcher = new HashMap<>();
        parenthesisMatcher.put(')', '(');
        parenthesisMatcher.put('}', '{');
        parenthesisMatcher.put(']', '[');

        HashSet<Character> openingParenthesis = new HashSet<>();
        openingParenthesis.add('(');
        openingParenthesis.add('{');
        openingParenthesis.add('[');
        HashSet<Character> closingParenthesis = new HashSet<>();
        closingParenthesis.add(')');
        closingParenthesis.add('}');
        closingParenthesis.add(']');

        Stack<Character> openingStack = new Stack<>();

        for(int i=0; i<stringWithParenthesis.length(); i++) {
            char currentChar = stringWithParenthesis.charAt(i);
            if(openingParenthesis.contains(currentChar)){
                openingStack.push(currentChar);
            } else{
                if(openingStack.empty()){
                    isValid = false;
                    break;
                }
                Character pop = openingStack.pop();
                Character character = parenthesisMatcher.get(currentChar);
                if(!character.equals(pop)){
                    isValid = false;
                    break;
                }
            }
        }

        if(!openingStack.isEmpty()){
            isValid = false;
        }
        return isValid;
    }

    private static boolean isValid2nd(String s){
        //check if 2nd half of the array are all closing and matches with the corresponding opening ones
         return true;
    }
}
