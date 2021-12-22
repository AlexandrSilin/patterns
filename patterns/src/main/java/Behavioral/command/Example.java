package Behavioral.command;

public class Example {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        RemoteControl.submit(new TurnOn(bulb));
        RemoteControl.submit(new TurnOff(bulb));
    }
}
