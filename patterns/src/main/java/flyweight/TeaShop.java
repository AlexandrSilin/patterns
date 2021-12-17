package flyweight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TeaShop {
    private final Queue<Order> orders;
    private final TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
        orders = new LinkedList<>();
    }

    public void takeOrder(int table, String teaType) {
        orders.add(new Order(table, teaType));
    }

    public void serve() {
        List<Tea> teaList = teaMaker.make(new ArrayList<>());
        while (!orders.isEmpty()) {
            Order order = orders.poll();
            if (teaList.isEmpty()) {
                teaList = teaMaker.make(teaList);
            }
            teaList.remove(teaList.size() - 1 % order.getTable());
            System.out.println("Serving table " + order.getTable() + " tea " + order.getTeaType());
        }
    }
}
