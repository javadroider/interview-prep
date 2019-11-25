package com.javadroider.interviewprep.designpatterns.creational.factory;

public class ShapeFactory {

	public static Shape getShape(int type) {

		Shape shape = null;
		switch (type) {
		case 1:
			shape = new Circle();
			break;
		case 2:
			shape = new Rectangle();
			break;
		}
		return shape;
	}
}
