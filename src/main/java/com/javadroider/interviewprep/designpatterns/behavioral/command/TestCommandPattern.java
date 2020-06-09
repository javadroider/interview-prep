package com.javadroider.interviewprep.designpatterns.behavioral.command;

public class TestCommandPattern {

    //client
    public static void main(String[] args) {

        //invoker
        Remotecontrol remotecontrol = new Remotecontrol();

        //receiver
        Bulb bulb = new Bulb();

        //commands
        ICommand onCommand = new SwitchOnBulb(bulb);
        ICommand offCommand = new SwitchOffBulb(bulb);

        remotecontrol.submit(onCommand);
        remotecontrol.submit(offCommand);
    }
}
