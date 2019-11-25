package com.javadroider.interviewprep.designpatterns.structural.decorator;

public class Client {

	public static void main(String[] args) {
		Decorator decorator = new ColorDecorator(new SimpleHouse());
		System.out.println(decorator.makeHouse());
	}

}
