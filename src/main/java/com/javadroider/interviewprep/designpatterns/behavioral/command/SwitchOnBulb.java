package com.javadroider.interviewprep.designpatterns.behavioral.command;

public class SwitchOnBulb implements ICommand {

    private Bulb bulb;
    public SwitchOnBulb(Bulb bulb){
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.on();
    }
}
