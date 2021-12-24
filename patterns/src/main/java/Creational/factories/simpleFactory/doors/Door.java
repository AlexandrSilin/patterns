package Creational.factories.simpleFactory.doors;

public abstract class Door {
    private final float width;
    private final float height;

    Door(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
