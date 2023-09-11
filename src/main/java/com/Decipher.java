package com;

/**
 * decipher("SERR CVMMN!")
 *
 * // FREE PIZZA!
 * A -> 13 -> (char) A -> N
 * B -> (diff(b-A) + 13)> 26 -> diff-> 5> char -> char -> deciphered
 * skip special Charcaters and spaces
 *
 */

public class Decipher {
    public static void main(String[] args) {
        String encodedString = "SERR CVMMN!";

        StringBuilder decodedString = new StringBuilder();
        for(int ind=0; ind<encodedString.length(); ind++){
            char letter = encodedString.charAt(ind);
            if(!Character.isAlphabetic(letter)){
                decodedString.append(letter);
                continue;
            }

            int offset = letter - 'A';
            int baseIntValue = offset + 13;
            if(baseIntValue >= 26){
                int roundedVal = baseIntValue - 26;
                decodedString.append((char) (65 + roundedVal));
            } else{
                decodedString.append((char) (65 + baseIntValue));
            }
        }
        System.out.println(decodedString);


        /**
         * Person{
         * name,
         * mobile
         *
         * public void setName(name){
         *  a = 98;
         * this.name = name;
         * }
         *
         * Person p  = ner Person()
         * p.setName("aman);
         * changeName(p);
         *
         * puvlic void changeName(Person p){
         *  p.setName("Shivam);
         * }
         *
         * A a = new A();     memory - [x -> newA() (objA) ] arr -> [1, 2, 3]
         * int a = passByvalue
         * pass by value, passbyreference
         *
         * stackMemory, -> local variable
         * heapMemory -> objects
         *
         * map -> to transform input data
         * reduce -> to perform aggregation
         */
    }
}
