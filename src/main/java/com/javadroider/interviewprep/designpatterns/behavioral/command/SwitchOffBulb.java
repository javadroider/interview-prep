package com.javadroider.interviewprep.designpatterns.behavioral.command;

public class SwitchOffBulb implements ICommand {

    private Bulb bulb;

    public SwitchOffBulb(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.off();
    }
}
