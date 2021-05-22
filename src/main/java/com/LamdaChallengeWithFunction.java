package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class LamdaChallengeWithFunction {
    private static String everySecondCharacter(Function<String, String> function, String param){
        return function.apply(param);
    }
    public static void main(String[] args) {
        Runnable runnable = ()->{
            String testString = "let's split this into an array";
            List<String> splitedArray = Arrays.asList(testString.split(","));
            System.out.println(splitedArray);
        };
        runnable.run();

        String source = "useLambaToManipulate";
        StringBuilder newString = new StringBuilder();
        Function<String, String> lambdaFunction = (s)->{
            for(int i =0 ; i<s.length(); i++){
                if(i%2==1){
                    newString.append(s.charAt(i));
                }
            }
            return newString.toString();
        };
        System.out.println(everySecondCharacter(lambdaFunction, source));

        Supplier<String> iLoveJava = ()->{return "I love java";};
        System.out.println(iLoveJava.get());
    }

}
