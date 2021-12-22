package Behavioral.command;

public class RemoteControl {
    private RemoteControl() {

    }

    public static void submit(Command command) {
        command.execute();
    }
}
