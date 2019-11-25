package com.javadroider.interviewprep.designpatterns.behavioral.interpreter;

public class MultiplyExpression implements Expression {
	private String expression;

	public MultiplyExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public int interpret(InterpreterEngine engine) {
		return engine.multiply(expression);
	}
}