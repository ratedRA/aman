package com.test;

import java.util.concurrent.CompletableFuture;

public class ThreadTest {

    public static void main(String[] args) {
        Thread loopWorker = new Thread(() -> {
            runMyLoop();
        });
        //CompletableFuture.runAsync()
        loopWorker.start();
        // most of the times this will be printed first, but if we change it to loopWorker.run Aman will be printed at last.
        System.out.println("Aman");
    }

    private static void runMyLoop(){
        for(int i=0; i<50; i++){
            System.out.println(i);
        }
    }
}
