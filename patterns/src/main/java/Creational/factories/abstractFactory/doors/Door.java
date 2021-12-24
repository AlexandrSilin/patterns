package Creational.factories.abstractFactory.doors;

public abstract class Door {
    protected final String description;

    protected Door(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Door{" +
                "description='" + description + '\'' +
                '}';
    }
}
