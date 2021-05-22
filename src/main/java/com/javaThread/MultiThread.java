package com.javaThread;
/*
1. create multiple number of thread.
2. call their start method and let them work on the same piece of the code.
 */
public class MultiThread {
    public static final String THREAD_1 = "thread1";
    public static final String THREAD_2 = "thread2";

    public static void main(String[] args) {
        Thread myFirstThread = new Thread(()->{
           letThemCount();
        });
        myFirstThread.setName(THREAD_1);

        Thread mySecondThread = new Thread(()->{
            letThemCount();
        });
        mySecondThread.setName(THREAD_2);
        myFirstThread.start();
        // System.out.println(Thread.currentThread().getName()+ " main thread invoked");
        mySecondThread.start();
    }

    // here i is the variable which is being used by both the thread.
    // threads of a process shares the same heap memory. and thus, they are they going to share the
    // the variable i (which is not local to thread)
    private static void letThemCount(){
        String threadName = Thread.currentThread().getName();
        for(int i = 0; i<20; i++){
            System.out.println(threadName+": "+i);
        }
    }
}
