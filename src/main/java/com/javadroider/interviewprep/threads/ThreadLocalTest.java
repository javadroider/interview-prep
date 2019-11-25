package com.javadroider.interviewprep.threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 1;
            }
        };

        @Override
        public void run() {

            local.set(new Random().nextInt(30));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(local.get());
        }
    }

}
