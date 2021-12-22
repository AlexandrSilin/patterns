package Creational.singleton;

public class President {
    private volatile static President instance;
    private final String name;

    private President(String name) {
        this.name = name;
    }

    public static President getInstance() {
        return instance == null ? instance = new President("president") : instance;
    }

    @Override
    public String toString() {
        return "President{" +
                "name='" + name + '\'' +
                '}';
    }
}
