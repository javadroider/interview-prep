package com.javadroider.interviewprep.designpatterns.behavioral.cor;

public class FiftyRupeeDispenser implements Chain {

	private Chain chain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 50) {
			int num = cur.getAmount() / 50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing " + num + " 50Rs note");
			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}

}