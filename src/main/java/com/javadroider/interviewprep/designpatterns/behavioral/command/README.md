1. It works by wrapping the request from the sender in an object called a command. 
2. This command is then passed to the invoker object, which proceeds to look for the adequate way to process the request. 
3. Once it finds the adequate way, it passes the command, where it will be executed.
4. Check [TestCommand.java](https://github.com/javadroider/AlgoDSInJava/blob/master/src/com/javadroider/designpatterns/behavioral/command/TestCommand.java) for detailed example.
5. This pattern encapsulates commands (method calls) in objects allowing us to issue requests without knowing the requested operation or the requesting object. It also provides the options to queue commands, undo/redo actions and other manipulations.
6. https://www.oodesign.com/command-pattern.html
