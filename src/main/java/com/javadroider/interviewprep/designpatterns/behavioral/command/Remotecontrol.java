package com.javadroider.interviewprep.designpatterns.behavioral.command;

public class Remotecontrol {

    public void submit(ICommand command){
        command.execute();
    }
}
