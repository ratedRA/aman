package com.javaThread;

import java.util.Random;

// one class for creating threads and one class for showing the race condition.
public class CriticalSectionDemonstration {
    public static void main(String[] args) {
        RaceCondition.runMultipleThread();
    }
}

class RaceCondition{
    int randInt;
    Random random = new Random();

    public void printer(){
        int i = 10000;
        while (i>0){
            if(randInt % 5 == 0){
                if(randInt % 5 != 0){
                    System.out.println(randInt);
                }
            }
            i-=1;
        }
    }

    private void modifier(){
        int i = 10000;
        while (i>0){
            randInt = random.nextInt(1000);
            i-=1;
        }
    }

    public static void runMultipleThread(){
        RaceCondition raceCondition = new RaceCondition();

        Thread printerThread = new Thread(() -> raceCondition.printer());
        Thread modifierThread = new Thread(() -> raceCondition.modifier());

        printerThread.start();
        modifierThread.start();
        try {
            printerThread.join();
            modifierThread.join();
        } catch (InterruptedException exception){
            // interruption occurred
        }
    }
}


