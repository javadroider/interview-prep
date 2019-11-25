package com.javadroider.interviewprep.concurrency;

public class UncaughtExceptionHandlerExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Integer.parseInt("1");
            Integer.parseInt("abc");
        });
        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.printf("An exception has been captured\n");
            System.out.printf("Thread: %s\n", t.getId());
            System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
            System.out.printf("Stack Trace: \n");
            e.printStackTrace(System.out);
            System.out.printf("Thread status: %s\n", t.getState());
        });

        thread.start();
    }
}
