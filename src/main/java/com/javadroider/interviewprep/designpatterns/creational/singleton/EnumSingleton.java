package com.javadroider.interviewprep.designpatterns.creational.singleton;

public enum EnumSingleton {

	INSTANCE;

	public void print() {
		System.out.println("I am here");
	}

	public static void main(String[] args) {
		EnumSingleton.INSTANCE.print();
	}
}
