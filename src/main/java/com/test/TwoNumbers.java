package com.test;

public class TwoNumbers {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void printAddition(){
        UtilClass utilClass = new UtilClass();
        int additions = utilClass.addNumbers(this);
        System.out.println(additions);
    }
}

class UtilClass{

    public int addNumbers(TwoNumbers twoNumbers){
        return twoNumbers.getA() + twoNumbers.getB();
    }
}

class MainForAddition{
    public static void main(String[] args) {
        TwoNumbers twoNumbers = new TwoNumbers();
        twoNumbers.setA(10);
        twoNumbers.setB(100);
        twoNumbers.printAddition();
    }
}
