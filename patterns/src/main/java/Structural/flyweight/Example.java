package Structural.flyweight;

public class Example {
    public static void main(String[] args) {
        TeaShop shop = new TeaShop(new TeaMaker());
        shop.takeOrder(2, "1");
        shop.takeOrder(3, "1");
        shop.takeOrder(4, "1");
        shop.takeOrder(5, "1");
        shop.takeOrder(6, "1");
        shop.takeOrder(7, "1");
        shop.takeOrder(8, "1");
        shop.takeOrder(9, "1");
        shop.takeOrder(10, "1");
        shop.takeOrder(11, "1");
        shop.takeOrder(12, "1");
        shop.serve();
    }
}
