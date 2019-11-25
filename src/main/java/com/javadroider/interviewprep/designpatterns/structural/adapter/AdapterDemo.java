package com.javadroider.interviewprep.designpatterns.structural.adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		after();
	}

	public static void after() {
		Shape[] shapes = { new RectangleAdapter(new Rectangle()), new LineAdapter(new Line()) };
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		for (Shape shape : shapes) {
			shape.draw(x1, y1, x2, y2);
		}
	}

	public static void before() {
		Object[] shapes = { new Line(), new Rectangle() };
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		int width = 40, height = 40;
		for (Object shape : shapes) {
			if (shape.getClass().getSimpleName().equals("Line")) {
				((Line) shape).draw(x1, y1, x2, y2);
			} else if (shape.getClass().getSimpleName().equals("Rectangle")) {
				((Rectangle) shape).draw(x2, y2, width, height);
			}
		}
	}
}