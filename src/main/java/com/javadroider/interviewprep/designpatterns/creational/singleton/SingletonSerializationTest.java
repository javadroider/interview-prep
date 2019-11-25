/**
 * 
 */
package com.javadroider.interviewprep.designpatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonSerializationTest {
	static DemoSingleton instanceOne = DemoSingleton.getInstance();

	public static void main(String[] args) {
		try {
			// Serialize to a file
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setI(20);

			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
			DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
			in.close();

			System.out.println(instanceOne.getI());
			System.out.println(instanceTwo.getI());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static class DemoSingleton implements Serializable {
		private static final long serialVersionUID = 1L;
		private volatile static DemoSingleton instance = null;

		public static DemoSingleton getInstance() {
			if (instance == null) {
				instance = new DemoSingleton();
			}
			return instance;
		}

		protected Object readResolve() {
			return instance;
		}

		private int i = 10;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
	}
}
