package flyweight;

public class Order {
    private final int table;
    private final String teaType;

    public Order(int table, String teaType) {
        this.table = table;
        this.teaType = teaType;
    }

    public int getTable() {
        return table;
    }

    public String getTeaType() {
        return teaType;
    }
}
