package proxy;

import proxy.door.Door;
import proxy.door.LabDoor;
import proxy.door.SecuredDoor;

public class Example {
    public static void main(String[] args) {
        Door labDoor = new LabDoor();
        Door securedDoor = new SecuredDoor(labDoor);
        labDoor.open();
        securedDoor.open();
        securedDoor.close();
        labDoor.close();
    }
}
