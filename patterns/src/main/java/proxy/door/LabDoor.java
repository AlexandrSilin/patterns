package proxy.door;

public class LabDoor extends Door {
    @Override
    public void open() {
        System.out.println("Opening lab door");
    }

    @Override
    public void close() {
        System.out.println("Closing the lab door");
    }
}
