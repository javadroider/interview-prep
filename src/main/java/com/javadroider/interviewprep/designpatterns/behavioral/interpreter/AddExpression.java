package com.javadroider.interviewprep.designpatterns.behavioral.interpreter;

public class AddExpression implements Expression {
	private String expression;

	public AddExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public int interpret(InterpreterEngine engine) {
		return engine.add(expression);
	}
}
