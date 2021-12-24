package Behavioral.strategy;

public class Example {
    public static void main(String[] args) {
        String[] array = new String[]{"1", "2", "3"};
        SortStrategy bubble = new BubbleSortStrategy();
        SortStrategy quick = new QuickSortStrategy();
        Sorter sorter = new Sorter(bubble);
        sorter.sort(array);
        sorter.setStrategy(quick);
        sorter.sort(array);
    }
}
