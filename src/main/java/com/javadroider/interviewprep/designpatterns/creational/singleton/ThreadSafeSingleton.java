package com.javadroider.interviewprep.designpatterns.creational.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    /**
     * This implementation works fine and provides thread-safety but it reduces the performance because of cost
     * associated with the synchronized method, although we need it only for the first few threads who might create
     * the separate instances. To avoid this extra overhead every time, double checked locking principle is used
     */
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    /**
     * Here synchronized block is used inside the if condition with an additional check to ensure that
     * only one instance of singleton class is created.Since null check is made 2 times in this code it is called
     * as double checked locking principle
     */
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}