package Structural.proxy;

import Structural.proxy.door.Door;
import Structural.proxy.door.LabDoor;
import Structural.proxy.door.SecuredDoor;

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
