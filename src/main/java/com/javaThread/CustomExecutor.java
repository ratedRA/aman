package com.javaThread;

import java.util.concurrent.Executor;

public class CustomExecutor {
    public static void main(String[] args) {
        ExampleExecutor exampleExecutor = new ExampleExecutor();
        ExampleRunnable exampleRunnable = new ExampleRunnable();
        exampleExecutor.execute(exampleRunnable);
    }

    static class ExampleExecutor implements Executor{
        @Override
        public void execute(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    static class ExampleRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("task is executing");
        }
    }

}
