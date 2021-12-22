package Structural.proxy.door;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecuredDoor extends Door {
    private final Door door;
    private final BufferedReader reader;

    public SecuredDoor(Door door) {
        this.door = door;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private boolean authenticate(String password) {
        return password.equals("secret");
    }

    @Override
    public void open() {
        try {
            System.out.println("Password: ");
            if (authenticate(reader.readLine())) {
                door.open();
            } else {
                System.out.println("Wrong password");
            }
        } catch (IOException e) {
            System.out.println("Terminal broken");
        }
    }

    @Override
    public void close() {
        door.close();
    }
}
