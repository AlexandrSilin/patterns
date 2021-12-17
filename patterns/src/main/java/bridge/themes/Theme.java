package bridge.themes;

public abstract class Theme {
    protected final String color;

    public Theme(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
