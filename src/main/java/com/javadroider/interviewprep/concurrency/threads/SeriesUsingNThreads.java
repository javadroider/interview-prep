package com.javadroider.interviewprep.concurrency.threads;

public class SeriesUsingNThreads {

    public static void main(String[] args) {
        int maxThreads = 4;
        Data data = new Data();
        for (int i = 1; i <= maxThreads; i++) {
            new Thread(new Logic(data, i, maxThreads)).start();
        }
    }

    private static class Logic implements Runnable {

        private final Data data;
        private int threadNumber;
        private int maxThreads;

        Logic(Data data, int threadNumber, int maxThreads) {
            this.data = data;
            this.threadNumber = threadNumber;
            this.maxThreads = maxThreads;
        }

        @Override
        public void run() {
            while (data.count < 100) {
                synchronized (data) {

                    while (data.currentThread != threadNumber) {
                        try {
                            data.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Thread-" + threadNumber + " :: " + data.count++);

                    int nextThread = threadNumber + 1;
                    if (nextThread > maxThreads) {
                        nextThread = 1;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    data.currentThread = nextThread;
                    data.notifyAll();
                }
            }
        }

    }

    public static class Data {
        int count;
        int currentThread = 1;
    }
}
