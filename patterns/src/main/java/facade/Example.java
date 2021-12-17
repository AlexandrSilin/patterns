package facade;

public class Example {
    public static void main(String[] args) {
        ComputerFacade facade = new ComputerFacade(new Computer());
        facade.turnOn();
        facade.turnOff();
    }
}
