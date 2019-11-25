package com.javadroider.interviewprep.designpatterns.creational.singleton;

/**
 * Bill Pugh implementation create the Singleton class using a inner static helper class.When the singleton class is loaded,
 * SingletonHelper class is not loaded into memory and only when someone calls the getInstance method, this class gets
 * loaded and creates the Singleton class instance.
 */
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}