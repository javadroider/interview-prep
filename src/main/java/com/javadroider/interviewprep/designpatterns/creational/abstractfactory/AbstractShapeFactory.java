package com.javadroider.interviewprep.designpatterns.creational.abstractfactory;

public class AbstractShapeFactory {

	public static ShapeFactory getShapeFactory(int type) {
		ShapeFactory shapeFactory = null;
		switch (type) {
		case 1:
			shapeFactory = new SimpleShapeFactory();
			break;
		case 2:
			shapeFactory = new ComplexShapeFactory();
			break;
		}

		return shapeFactory;
	}

}
