package Behavioral.command;

public class TurnOn implements Command {
    private final Bulb bulb;

    public TurnOn(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.turnOn();
    }

    @Override
    public void undo() {
        bulb.tunOff();
    }

    @Override
    public void redo() {
        execute();
    }
}
