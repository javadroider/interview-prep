package com.javadroider.interviewprep.designpatterns.behavioral.interpreter;

public class InterpreterTest {
	private InterpreterEngine engine;

	public InterpreterTest(InterpreterEngine engine) {
		this.engine = engine;
	}

	public int interpret(String input) {
		Expression expression = null;

		if (input.contains("add")) {
			expression = new AddExpression(input);
		} else if (input.contains("multiply")) {
			expression = new MultiplyExpression(input);
		}

		int result = expression.interpret(engine);
		System.out.println(input);
		return result;
	}

	public static void main(String[] args) {
		InterpreterTest main = new InterpreterTest(new InterpreterEngine());

		System.out.println("Result: " + main.interpret("add 15 and 25"));
		System.out.println("Result: " + main.interpret("multiply " + main.interpret("add 5 and 5") + " and 10"));
	}
}