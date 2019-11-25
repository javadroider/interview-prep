package com.javadroider.interviewprep.designpatterns.creational.factory;

public class Client {

	public static void main(String[] args) {
		Shape shape1 = ShapeFactory.getShape(1);
		Shape shape2 = ShapeFactory.getShape(2);
		shape1.draw();
		shape2.draw();
	}
}
