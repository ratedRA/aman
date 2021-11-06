package com.cpp.leetCode;

import com.cpp.CommonFastReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone17 {
    public static void main(String[] args) {
        CommonFastReader fastReader = new CommonFastReader();
        String inputDigits = fastReader.nextLine();

        if(inputDigits == null){
            System.out.println(new ArrayList<>());
        }

        Map<Character, String> digitLetterMap = new HashMap<>();
        digitLetterMap.put('2', "abc");
        digitLetterMap.put('3', "def");
        digitLetterMap.put('4', "ghi");
        digitLetterMap.put('5', "jkl");
        digitLetterMap.put('6', "mno");
        digitLetterMap.put('7', "pqrs");
        digitLetterMap.put('8', "tuv");
        digitLetterMap.put('9', "wxyz");

        List<String> answers = permuteUsingBacktrack(inputDigits, 0, digitLetterMap, new ArrayList<>(), new StringBuilder());
        System.out.println(answers);
    }

    private static List<String> permuteUsingBacktrack(String inputDigits, int idx, Map<Character, String> map, List<String> ans, StringBuilder currentStr){
        if(inputDigits.length() == currentStr.length()){
            ans.add(currentStr.toString());
            return ans;
        }

        String keypadMapValue = map.get(inputDigits.charAt(idx));
        for(int i=0; i<keypadMapValue.length(); i++){
            currentStr.append(keypadMapValue.charAt(i));
            permuteUsingBacktrack(inputDigits, idx+1, map, ans, currentStr);
            currentStr.deleteCharAt(currentStr.length()-1);
        }

        return ans;
    }
}
