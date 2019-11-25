package com.javadroider.interviewprep.designpatterns.behavioral.cor;

public class TenRupeeDispenser implements Chain {

	private Chain chain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 10) {
			int num = cur.getAmount() / 10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing " + num + " 10Rs note");
			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}

}