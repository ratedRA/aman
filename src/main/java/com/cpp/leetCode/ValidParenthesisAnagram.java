package com.cpp.leetCode;

import com.cpp.CommonFastReader;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class ValidParenthesisAnagram extends CommonFastReader {
    public static void main(String[] args) {
        CommonFastReader commonFastReader = new CommonFastReader();
        int n = commonFastReader.nextInt();
        String parString = "";
        for(int i=0; i<2*n; i++){
            if(i%2==0){
                parString += "(";
            } else{
                parString += ")";
            }
        }
        Set<String> allUniqueParen = generateUniqueAndReturnAnagrams(parString, "", new HashSet<>());
        List<String> validUnique = allUniqueParen.stream().filter(s -> isValid(s)).collect(Collectors.toList());

        System.out.println(validUnique);
    }

    private static Set<String> generateUniqueAndReturnAnagrams(String str, String anagram, Set<String> resList){
        if(StringUtils.isEmpty(str)){
            resList.add(anagram);
            return resList;
        }

        for(int i=0; i<str.length(); i++){
            Character cur = str.charAt(i);

            String restStr = str.substring(0, i) + str.substring(i+1);
            generateUniqueAndReturnAnagrams(restStr, anagram+cur, resList);
            //System.out.println(resList);
        }
        return resList;
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
}
