/**
 *
 */
package com.javadroider.interviewprep.designpatterns.creational.singleton;

import java.io.Serializable;

/**
 * This approach creates singleton which protects from serialization and reflection
 */
public class SerializedReflectionFreeSingleton implements Serializable {


    private static SerializedReflectionFreeSingleton INSTANCE = null;

    private SerializedReflectionFreeSingleton() {

        //This will throw exception when someone tries to load class using reflection
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance method");
        }
    }

    public static SerializedReflectionFreeSingleton getInstance() {
        if (INSTANCE == null) {

            synchronized (SerializedReflectionFreeSingleton.class) {

                if (INSTANCE == null) {
                    INSTANCE = new SerializedReflectionFreeSingleton();
                }
            }
        }
        return INSTANCE;
    }

    //this will protect from serialization
    protected SerializedReflectionFreeSingleton readResolve() {
        return getInstance();
    }
}
