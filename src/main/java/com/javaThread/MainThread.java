package com.javaThread;

import static java.lang.Thread.currentThread;

public class MainThread{

    public static void main(String[] args) {
        System.out.println("hello from the main thread");
        Thread anotherThread = new AnotherThread();
        // we can also set the name of the thread.
        anotherThread.setName("__AnotherThread__");
        anotherThread.start();
        System.out.println("hello again from the main thread");

        Thread anonymousThread = new Thread() {
            @Override
            public void run() {
                System.out.println("hello from anonymous class thread"+" " +currentThread().getName());
            }
        };
        anonymousThread.setName("__AnonymousThread__");
        anonymousThread.start();

        /*Runnable runnableThread = () -> {
            System.out.println("hello from runnable thread");
        };
        runnableThread.run(); // this will run in the main thread only.
        // we are directly calling something with is overriden by us only.
        // all the magic happens inside start() Method of thread as it creates
        // new thread and execute the run method inside new thread.*/

        Thread myRunnableThread = new Thread(() -> System.out.println("hello from Runnable Thread"+ " "+ currentThread().getName()));
        myRunnableThread.setName("--MyRunnableThread--");
        myRunnableThread.start();

        Thread myRunnableThreadWithLambda = new Thread(() -> System.out.println("hello from Runnable Thread"));
        myRunnableThreadWithLambda.setName("__MyRunnableThreadWithLambda__");
        myRunnableThreadWithLambda.start();

        // Thread sleep, Interrupt and join.

        // sleep and interrupt
        Thread putThisToSleep = new Thread(()->{
            try{
                Thread.sleep(3000);
                System.out.println("have put this thread to sleep");
                currentThread().setName("calledThread");
                System.out.println(currentThread().getName()+" is executing");
            } catch (InterruptedException e){
                System.out.println("interrupted while sleeping");
            }
        });
        putThisToSleep.start();
        // putThisToSleep.interrupt();

        // join
        Thread useJoinThread = new Thread(()->{
            System.out.println("this join thread will execute after the put this to sleep has been executed");
            currentThread().setName("calling thread");
            try{
                putThisToSleep.join();
            } catch (InterruptedException e){
                System.out.println("interrupted while sleeping");
            }
            System.out.println(currentThread().getName()+" is getting executed");
        });
        useJoinThread.start();

    }

    private static class AnotherThread extends java.lang.Thread{
        @Override
        public void run() {
            System.out.println("hello from another thread" + " " +currentThread().getName());
        }
    }

    private static class MyRunnableThread implements Runnable{
        @Override
        public void run() {
            System.out.println("hello from Runnable Thread");
        }
    }
}
