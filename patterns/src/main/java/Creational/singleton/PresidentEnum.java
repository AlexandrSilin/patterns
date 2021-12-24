package Creational.singleton;

public enum PresidentEnum {
    INSTANCE;
    private final String name;

    PresidentEnum() {
        this.name = "presidentEnum";
    }

    @Override
    public String toString() {
        return "PresidentEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}
