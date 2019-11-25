package com.javadroider.interviewprep.designpatterns.behavioral.cor;

public class TwentyRupeeDispenser implements Chain {

	private Chain chain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 20) {
			int num = cur.getAmount() / 20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing " + num + " 20Rs note");
			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}

}