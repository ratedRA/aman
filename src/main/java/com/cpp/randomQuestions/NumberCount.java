package com.cpp.randomQuestions;

import java.util.Scanner;

public class NumberCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String resultString = "";
        for(int i=0; i<sentence.length(); i++){
            if(Character.isDigit(sentence.charAt(i))){
                resultString += sentence.charAt(i);
                if(i<sentence.length()-1) {
                    if (Character.isLetter(sentence.charAt(i + 1)) || sentence.charAt(i + 1) == ' ' || sentence.charAt(i + 1) == '.') {
                        resultString += " ";
                    }
                }
            }
        }
        String[] splittedBySpace = resultString.split(" ");
        System.out.println(splittedBySpace.length);
    }
}
