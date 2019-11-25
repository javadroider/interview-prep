package com.javadroider.interviewprep.designpatterns.behavioral.cor;

import java.util.Scanner;

public class ChainOfRespTest {

	private Chain c1;

	public ChainOfRespTest() {
		// initialize the chain
		this.c1 = new FiftyRupeeDispenser();
		Chain c2 = new TwentyRupeeDispenser();
		Chain c3 = new TenRupeeDispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	void dispense(Currency cur){
		this.c1.dispense(cur);
	}
	public static void main(String[] args) {
		ChainOfRespTest atmDispenser = new ChainOfRespTest();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.dispense(new Currency(amount));
		}

	}

}