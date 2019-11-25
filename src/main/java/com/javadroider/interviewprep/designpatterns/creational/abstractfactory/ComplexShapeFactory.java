package com.javadroider.interviewprep.designpatterns.creational.abstractfactory;

public class ComplexShapeFactory implements ShapeFactory {

	public Shape getShape(int type) {

		Shape shape = null;
		switch (type) {
		case 3:
			shape = new Hexagon();
			break;
		}
		return shape;
	}
}
