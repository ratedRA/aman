package com.javaThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor {
    private static final int THREAD_POOL_SIZE = 4;
    public static void main(String[] args) {
        Instruction instruction = new Instruction();
        for(int i = 0; i<100; i++){
            instructionExecutor(instruction);
        }
    }

    static class Instruction{
        static int i = 1;

        public void execute(){
            synchronized (this) {
                System.out.println("Task is executing with i: " + i);
                i++;
            }
        }
    }

    static void instructionExecutor(Instruction instruction){
        Executor executor = Executors.newFixedThreadPool(4);
        executor.execute(() -> instruction.execute());
    }
}
